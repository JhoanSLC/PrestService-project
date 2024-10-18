package com.finalboss_project.finalboss.ordenTrabajo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.ordenServicio.domain.repository.IOrdenServicioRepo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.repository.IOrdenTrabajoRepository;
import com.finalboss_project.finalboss.ordenTrabajo.dto.OrdenTrabajoDto;
import com.finalboss_project.finalboss.ordenTrabajo.mapper.OrdenTrabajoMapper;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;

@Service
public class OrdenTrabajoServiceImpl implements IOrdenTrabajoService {

    @Autowired
    private IOrdenTrabajoRepository repository;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private IOrdenServicioRepo ordenServicioRepo;

    @Override
    public OrdenTrabajoDto create(OrdenTrabajoDto dto) {
        String personaId = dto.getEmpleadoId();
        Long ordenServicioId = dto.getOrdenServicioId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con ID: "+personaId+" no encontrada"));
        OrdenServicio ordenServicio = ordenServicioRepo.findById(ordenServicioId).orElseThrow(() -> new ResourceNotFoundException("OrdenServicio con ID: "+ordenServicioId+" no encontrado"));
        OrdenTrabajo entidad = new OrdenTrabajo(
            dto.getId(),
            dto.getNumeroOrdentrabajo(),
            dto.getFechaAsignacion(),
            dto.getHoraAsignacion(),
            persona,
            ordenServicio
        );
        OrdenTrabajo entidadGuardada = repository.save(entidad);
        return OrdenTrabajoMapper.toDto(entidadGuardada);
    }

    @Override
    public OrdenTrabajoDto getById(Long id) {
        OrdenTrabajo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con el id: " + id + " no encontrado"));
        return OrdenTrabajoMapper.toDto(entidad);
    }
       

    @Override
    public List<OrdenTrabajoDto> getAll() {
       List<OrdenTrabajo> entidades = repository.findAll();
       return entidades.stream()
                .map(OrdenTrabajoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrdenTrabajoDto update(Long id, OrdenTrabajoDto updatedDto) {
        String personaId = updatedDto.getEmpleadoId();
        Long ordenServicioId = updatedDto.getOrdenServicioId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con ID: "+personaId+" no encontrada"));
        OrdenServicio ordenServicio = ordenServicioRepo.findById(ordenServicioId).orElseThrow(() -> new ResourceNotFoundException("OrdenServicio con ID: "+ordenServicioId+" no encontrado"));
        OrdenTrabajo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con el id: " + id + " no encontrado"));
        entidad.setNumeroOrdenTrabajo(updatedDto.getNumeroOrdentrabajo());
        entidad.setFechaAsignacion(updatedDto.getFechaAsignacion());
        entidad.setHoraAsignacion(updatedDto.getHoraAsignacion());
        entidad.setEmpleado(persona);
        entidad.setOrdenServicio(ordenServicio);
        repository.save(entidad);
        return OrdenTrabajoMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }


}
