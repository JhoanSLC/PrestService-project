package com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.repository.IEstadoOrdenTrabajoRepo;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.dto.EstadoOrdenTrabajoDto;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.mapper.EstadoOrdenTrabajoMapper;


@Service
public class EstadoOrdenTrabajoServiceImpl implements IEstadoOrdenTrabajoService{

    @Autowired
    private IEstadoOrdenTrabajoRepo repository;

    @Override
    public EstadoOrdenTrabajoDto create(EstadoOrdenTrabajoDto dto) {
        EstadoOrdenTrabajo entidad = new EstadoOrdenTrabajo(
            dto.getId(),
            dto.getNombre()
        );
        EstadoOrdenTrabajo entidadGuardada = repository.save(entidad);
        return EstadoOrdenTrabajoMapper.toDto(entidadGuardada);
    }

    @Override
    public EstadoOrdenTrabajoDto getById(Long id) {
        EstadoOrdenTrabajo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenTrabajo con el id: " + id + " no encontrado"));
        return EstadoOrdenTrabajoMapper.toDto(entidad);
    }
       

    @Override
    public List<EstadoOrdenTrabajoDto> getAll() {
       List<EstadoOrdenTrabajo> entidades = repository.findAll();
       return entidades.stream()
                .map(EstadoOrdenTrabajoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoOrdenTrabajoDto update(Long id, EstadoOrdenTrabajoDto updatedDto) {
        EstadoOrdenTrabajo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenTrabajo con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return EstadoOrdenTrabajoMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenTrabajo con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

    

}
