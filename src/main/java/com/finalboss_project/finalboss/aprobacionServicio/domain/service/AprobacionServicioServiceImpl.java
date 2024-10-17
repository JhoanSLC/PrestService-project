package com.finalboss_project.finalboss.aprobacionServicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.aprobacionServicio.domain.entity.AprobacionServicio;
import com.finalboss_project.finalboss.aprobacionServicio.domain.repository.IAprobacionServicioRepository;
import com.finalboss_project.finalboss.aprobacionServicio.dto.AprobacionServicioDto;
import com.finalboss_project.finalboss.aprobacionServicio.mapper.AprobacionServicioMapper;
import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.estadoAprobacion.domain.entity.EstadoAprobacion;
import com.finalboss_project.finalboss.estadoAprobacion.domain.repository.IEstadoAprobacionRepo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.repository.IOrdenTrabajoRepository;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;

@Service
public class AprobacionServicioServiceImpl implements IAprobacionServicioService{

    @Autowired
    private IAprobacionServicioRepository repository;

    @Autowired
    private IOrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private IServicioRepo servicioRepo;

    @Autowired
    private  IEstadoAprobacionRepo estadoAprobRepo;

    @Override
    public AprobacionServicioDto create(AprobacionServicioDto dto) {
        Long ordenTrabajoId = dto.getOrdenTrabajoId();
        String personaId = dto.getPersonaId();
        Long servicioId = dto.getServicioId();
        Long estadoAprobacionId = dto.getEstadoAprobacionId();

        OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findById(ordenTrabajoId)
                        .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con id: "+ ordenTrabajoId + " no encontrada"));
        
        Persona persona = personaRepo.findById(personaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Persona con id: "+ personaId + " no encontrada"));

        Servicio servicio = servicioRepo.findById(servicioId)
                        .orElseThrow(() -> new ResourceNotFoundException("Servicio con el id: "+servicioId+" no encontrado"));
        
        EstadoAprobacion estadoAprobacion = estadoAprobRepo.findById(estadoAprobacionId)
                        .orElseThrow(() -> new ResourceNotFoundException("EstadoAprobacion con id: "+estadoAprobacionId+" no encontrado"));

        AprobacionServicio entidad = new AprobacionServicio(
            dto.getId(),
            ordenTrabajo,
            persona,
            servicio,
            dto.getHallazgo(),
            dto.getSolucion(),
            estadoAprobacion
        );
        AprobacionServicio entidadGuardada = repository.save(entidad);
        return AprobacionServicioMapper.toDto(entidadGuardada);


    }

    @Override
    public AprobacionServicioDto getById(Long id) {
        AprobacionServicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AprobacionServicio con el id: "+id+" no encontrado"));
        return AprobacionServicioMapper.toDto(entidad);
    }

    @Override
    public List<AprobacionServicioDto> getAll() {
        List<AprobacionServicio> entidades = repository.findAll();
        return entidades.stream()
                .map(AprobacionServicioMapper::toDto)
                .collect(Collectors.toList());            
    }

    @Override
    public AprobacionServicioDto update(Long id, AprobacionServicioDto updatedDto) {
        
        Long ordenTrabajoId = updatedDto.getOrdenTrabajoId();
        String personaId = updatedDto.getPersonaId();
        Long servicioId = updatedDto.getServicioId();
        Long estadoAprobacionId = updatedDto.getEstadoAprobacionId();
        
        AprobacionServicio entidad = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("AprobacionServicio con el id: "+id+" no encontrado"));

        OrdenTrabajo ordenTrabajo = ordenTrabajoRepository.findById(ordenTrabajoId)
                        .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con id: "+ ordenTrabajoId + " no encontrada"));
        
        Persona persona = personaRepo.findById(personaId)
                        .orElseThrow(() -> new ResourceNotFoundException("Persona con id: "+ personaId + " no encontrada"));

        Servicio servicio = servicioRepo.findById(servicioId)
                        .orElseThrow(() -> new ResourceNotFoundException("Servicio con el id: "+servicioId+" no encontrado"));
        
        EstadoAprobacion estadoAprobacion = estadoAprobRepo.findById(estadoAprobacionId)
                        .orElseThrow(() -> new ResourceNotFoundException("EstadoAprobacion con id: "+estadoAprobacionId+" no encontrado"));

        entidad.setEstadoAprobacion(estadoAprobacion);
        entidad.setHallazgo(updatedDto.getHallazgo());
        entidad.setOrdenTrabajo(ordenTrabajo);
        entidad.setPersona(persona);
        entidad.setServicio(servicio);
        entidad.setSolucion(updatedDto.getSolucion());

        return AprobacionServicioMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("AprobacionServicio con el id: "+id+" no encontrado"));
        repository.deleteById(id);
    }

}
