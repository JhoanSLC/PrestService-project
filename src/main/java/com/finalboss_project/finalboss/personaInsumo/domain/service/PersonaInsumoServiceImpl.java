package com.finalboss_project.finalboss.personaInsumo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.insumo.domain.repository.IInsumoRepo;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumo;
import com.finalboss_project.finalboss.personaInsumo.domain.entity.PersonaInsumoPk;
import com.finalboss_project.finalboss.personaInsumo.domain.repository.IPersonaInsumoRepo;
import com.finalboss_project.finalboss.personaInsumo.dto.PersonaInsumoDto;
import com.finalboss_project.finalboss.personaInsumo.mapper.PersonaInsumoMapper;

@Service
public class PersonaInsumoServiceImpl implements IPersonaInsumoService {

    @Autowired
    private IPersonaInsumoRepo repository;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private IInsumoRepo insumoRepo;

    @Autowired
    private IServicioRepo servicioRepo;

    @Override
    public PersonaInsumoDto create(PersonaInsumoDto dto) {
        Persona persona = personaRepo.findById(dto.getPersonaId())
                .orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: " + dto.getPersonaId() + " no encontrado"));
        Insumo insumo = insumoRepo.findById(dto.getInsumoId())
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el ID: " + dto.getInsumoId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(dto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el ID: " + dto.getServicioId() + " no encontrado"));

        PersonaInsumo entidad = PersonaInsumoMapper.toEntity(dto);
        entidad.setPersona(persona);
        entidad.setInsumo(insumo);
        entidad.setServicio(servicio);

        PersonaInsumo entidadGuardada = repository.save(entidad);
        return PersonaInsumoMapper.toDto(entidadGuardada);
    }

    @Override
    public PersonaInsumoDto getById(String personaId, Long insumoId) {
        PersonaInsumoPk id = new PersonaInsumoPk(personaId, insumoId);
        PersonaInsumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonaInsumo no encontrado"));
        return PersonaInsumoMapper.toDto(entidad);
    }

    @Override
    public List<PersonaInsumoDto> getAll() {
        List<PersonaInsumo> entidades = repository.findAll();
        return entidades.stream().map(PersonaInsumoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public PersonaInsumoDto update(String personaId, Long insumoId, PersonaInsumoDto updatedDto) {
        PersonaInsumoPk id = new PersonaInsumoPk(personaId, insumoId);
        PersonaInsumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonaInsumo no encontrado"));

        Persona persona = personaRepo.findById(updatedDto.getPersonaId())
                .orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: " + updatedDto.getPersonaId() + " no encontrado"));
        Insumo insumo = insumoRepo.findById(updatedDto.getInsumoId())
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el ID: " + updatedDto.getInsumoId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(updatedDto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el ID: " + updatedDto.getServicioId() + " no encontrado"));

        entidad.setPersona(persona);
        entidad.setInsumo(insumo);
        entidad.setServicio(servicio);

        return PersonaInsumoMapper.toDto(repository.save(entidad));
    }

    @Override
    public void delete(String personaId, Long insumoId) {
        PersonaInsumoPk id = new PersonaInsumoPk(personaId, insumoId);
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PersonaInsumo no encontrado"));
        repository.deleteById(id);
    }
}
