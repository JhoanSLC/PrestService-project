package com.finalboss_project.finalboss.estadoOrdenServicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity.EstadoOrdenServicio;
import com.finalboss_project.finalboss.estadoOrdenServicio.domain.repository.IEstadoOrdenServicioRepo;
import com.finalboss_project.finalboss.estadoOrdenServicio.dto.EstadoOrdenServicioDto;
import com.finalboss_project.finalboss.estadoOrdenServicio.mapper.EstadoOrdenServicioMapper;

@Service
public class EstadoOrdenServicioImpl implements IEstadoOrdenServicioService {

    @Autowired
    private IEstadoOrdenServicioRepo repository;

    @Override
    public EstadoOrdenServicioDto create(EstadoOrdenServicioDto dto) {
        EstadoOrdenServicio entidad = new EstadoOrdenServicio(
            dto.getId(),
            dto.getNombre()
        );
        EstadoOrdenServicio entidadGuardada = repository.save(entidad);
        return EstadoOrdenServicioMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenServicio con id: " + id + " No encontrado"));
        repository.deleteById(id);
    }

    @Override
    public List<EstadoOrdenServicioDto> getAll() {
        List<EstadoOrdenServicio> entidades = repository.findAll();
        return entidades.stream()
                .map(EstadoOrdenServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoOrdenServicioDto getById(Long id) {
        EstadoOrdenServicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenServicio con id: " + id + " no encontrada"));
        return EstadoOrdenServicioMapper.toDto(entidad);
    }

    @Override
    public EstadoOrdenServicioDto update(Long id, EstadoOrdenServicioDto updatedDto) {
        EstadoOrdenServicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenServicio con id: " + id + " no encontrada"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return EstadoOrdenServicioMapper.toDto(entidad);
    }

}
