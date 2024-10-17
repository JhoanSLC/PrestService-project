package com.finalboss_project.finalboss.estadoAprobacion.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;
import com.finalboss_project.finalboss.estadoAprobacion.domain.repository.IEstadoAprobacionRepo;
import com.finalboss_project.finalboss.estadoAprobacion.dto.EstadoAprobacionDto;
import com.finalboss_project.finalboss.estadoAprobacion.mapper.EstadoAprobacionMapper;

@Service
public class EstadoAprobacionServiceImpl implements IEstadoAprobacionService {

    @Autowired
    private IEstadoAprobacionRepo repository;

    @Override
    public EstadoAprobacionDto create(EstadoAprobacionDto dto) {
        EstadoAprobacion entidad = new EstadoAprobacion(
            dto.getId(),
            dto.getNombre()
        );
        EstadoAprobacion entidadGuardada = repository.save(entidad);
        return EstadoAprobacionMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoAprobacion con id: " + id + " No encontrado"));
        repository.deleteById(id);
    }

    @Override
    public List<EstadoAprobacionDto> getAll() {
        List<EstadoAprobacion> entidades = repository.findAll();
        return entidades.stream()
                .map(EstadoAprobacionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoAprobacionDto getById(Long id) {
        EstadoAprobacion entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoAprobacion con id: " + id + " no encontrada"));
        return EstadoAprobacionMapper.toDto(entidad);
    }

    @Override
    public EstadoAprobacionDto update(Long id, EstadoAprobacionDto updatedDto) {
        EstadoAprobacion entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoAprobacion con id: " + id + " no encontrada"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return EstadoAprobacionMapper.toDto(entidad);
    }

}
