package com.finalboss_project.finalboss.telPersona.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.telPersona.domain.entity.TelPersona;
import com.finalboss_project.finalboss.telPersona.domain.repository.ITelPersonaRepo;
import com.finalboss_project.finalboss.telPersona.dto.TelPersonaDto;
import com.finalboss_project.finalboss.telPersona.mappper.TelPersonaMapper;
import com.finalboss_project.finalboss.tipoTelefono.domain.entity.TipoTelefono;
import com.finalboss_project.finalboss.tipoTelefono.domain.repository.ITipoTelefonoRepo;

@Service
public class TelPersonaServiceImpl implements ITelPersonaService{

    @Autowired
    private ITelPersonaRepo repository;

    @Autowired
    private ITipoTelefonoRepo tipoTelefonoRepo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    public TelPersonaDto create(TelPersonaDto dto) {
        Long tipoTelefonoId = dto.getTipoTelefonoId();
        String personaId = dto.getPersonaId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con ID: "+personaId+" no encontrada"));
        TipoTelefono tipoTelefono = tipoTelefonoRepo.findById(tipoTelefonoId).orElseThrow(() -> new ResourceNotFoundException("TipoTelefono con ID: "+tipoTelefonoId+" no encontrado"));
        TelPersona entidad = new TelPersona(
            dto.getId(),
            dto.getNumero(),
            tipoTelefono,
            persona
        );
        TelPersona entidadGuardada = repository.save(entidad);
        return TelPersonaMapper.toDto(entidadGuardada);
    }

    @Override
    public TelPersonaDto getById(Long id) {
        TelPersona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TelPersona con el id: " + id + " no encontrado"));
        return TelPersonaMapper.toDto(entidad);
    }
       

    @Override
    public List<TelPersonaDto> getAll() {
       List<TelPersona> entidades = repository.findAll();
       return entidades.stream()
                .map(TelPersonaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TelPersonaDto update(Long id, TelPersonaDto updatedDto) {
        TelPersona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TelPersona con el id: " + id + " no encontrado"));
        Long tipoTelefonoId = updatedDto.getTipoTelefonoId();
        String personaId = updatedDto.getPersonaId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con ID: "+personaId+" no encontrada"));
        TipoTelefono tipoTelefono = tipoTelefonoRepo.findById(tipoTelefonoId).orElseThrow(() -> new ResourceNotFoundException("TipoTelefono con ID: "+tipoTelefonoId+" no encontrado"));
        entidad.setNumero(updatedDto.getNumero());
        entidad.setPersona(persona);
        entidad.setTipoTelefono(tipoTelefono);
        repository.save(entidad);
        return TelPersonaMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TelPersona con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
