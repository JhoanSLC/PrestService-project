package com.finalboss_project.finalboss.ordenServicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.estadoOrdenServicio.domain.entity.EstadoOrdenServicio;
import com.finalboss_project.finalboss.estadoOrdenServicio.domain.repository.IEstadoOrdenServicioRepo;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.ordenServicio.domain.repository.IOrdenServicioRepo;
import com.finalboss_project.finalboss.ordenServicio.dto.OrdenServicioDto;
import com.finalboss_project.finalboss.ordenServicio.mapper.OrdenServicioMapper;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;

@Service
public class OrdenServicioImpl implements IOrdenServicioService {

    @Autowired
    private IOrdenServicioRepo repository;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private IEstadoOrdenServicioRepo estadoOrdenServicioRepo;

    @Override
    public OrdenServicioDto create(OrdenServicioDto dto) {
        String clienteId = dto.getClienteId();
        String empleadoId = dto.getEmpleadoId();
        Long estadoOrdenId = dto.getEstadoOrdenServicioId();
        Persona cliente = personaRepo.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+clienteId+" no encontrado"));
        Persona empleado = personaRepo.findById(empleadoId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+empleadoId+" no encontrado"));
        EstadoOrdenServicio estado = estadoOrdenServicioRepo.findById(estadoOrdenId).orElseThrow(() -> new ResourceNotFoundException("estadoOrdenTrabajo con ID: "+estadoOrdenId+" no encontrado"));
        OrdenServicio entidad = new OrdenServicio(
            dto.getId(),
            dto.getFechaOrden(),
            cliente,
            empleado,
            estado
        );
        OrdenServicio entidadGuardada = repository.save(entidad);
        return OrdenServicioMapper.toDto(entidadGuardada);
    }

    @Override
    public OrdenServicioDto getById(Long id) {
        OrdenServicio entidad = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenServicio con el ID: "+id+" no encontrado"));
        return OrdenServicioMapper.toDto(entidad);
    }

    @Override
    public List<OrdenServicioDto> getAll() {
        List<OrdenServicio> entidades = repository.findAll();
        return entidades.stream().map(OrdenServicioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrdenServicioDto update(Long id, OrdenServicioDto updatedDto) {
        OrdenServicio entidad = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenServicio con el ID: "+id+" no encontrado"));
        String clienteId = updatedDto.getClienteId();
        String empleadoId = updatedDto.getEmpleadoId();
        Long estadoOrdenId = updatedDto.getEstadoOrdenServicioId();
        Persona cliente = personaRepo.findById(clienteId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+clienteId+" no encontrado"));
        Persona empleado = personaRepo.findById(empleadoId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+empleadoId+" no encontrado"));
        EstadoOrdenServicio estado = estadoOrdenServicioRepo.findById(estadoOrdenId).orElseThrow(() -> new ResourceNotFoundException("estadoOrdenTrabajo con ID: "+estadoOrdenId+" no encontrado"));
        entidad.setFechaOrden(updatedDto.getFechaOrden());
        entidad.setCliente(cliente);
        entidad.setEmpleado(empleado);
        entidad.setEstadoOrdenServicio(estado);
        return OrdenServicioMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenServicio con el ID: "+id+" no encontrado"));
        repository.deleteById(id);

    }

}
