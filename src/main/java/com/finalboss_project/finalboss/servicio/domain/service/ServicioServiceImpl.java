package com.finalboss_project.finalboss.servicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;

import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;
import com.finalboss_project.finalboss.servicio.dto.ServicioDto;
import com.finalboss_project.finalboss.servicio.mapper.ServicioMapper;

@Service
public class ServicioServiceImpl implements IServicioService {

    @Autowired
    private IServicioRepo repository;

    @Override
    public ServicioDto create(ServicioDto dto) {
        Servicio entidad = ServicioMapper.toEntity(dto);
        Servicio entidadGuardada = repository.save(entidad);
        return ServicioMapper.toDto(entidadGuardada);
    }

    @Override
    public ServicioDto getById(Long id) {
        Servicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el id: " + id + " no encontrado"));
        return ServicioMapper.toDto(entidad);
    }
       

    @Override
    public List<ServicioDto> getAll() {
       List<Servicio> entidades = repository.findAll();
       return entidades.stream()
                .map(ServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDto update(Long id, ServicioDto updatedDto) {
        Servicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setRequiereInsumo(updatedDto.getRequiereInsumo());
        entidad.setTiempoEjecucion(updatedDto.getTiempoEjecucion());
        repository.save(entidad);
        return ServicioMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
