package com.finalboss_project.finalboss.persona.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;
import com.finalboss_project.finalboss.persona.mapper.PersonaMapper;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.sucursal.domain.repository.ISucursalRepo;
import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;
import com.finalboss_project.finalboss.tipoPersona.domain.repository.ITipoPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService {

    @Autowired
    private IPersonaRepo repository;

    @Autowired
    private ISucursalRepo sucursalRepo;

    @Autowired
    private ITipoPersonaRepo tipoPersonaRepo;

    @Override
    public PersonaDto create(PersonaDto dto) {
        Long sucursalId = dto.getSucursal();
        Long tipoPersonaId = dto.getTipoPersona();
        Sucursal sucursal = sucursalRepo.findById(sucursalId).orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID: "+sucursalId+" no encontrado"));
        TipoPersona tipoPersona = tipoPersonaRepo.findById(tipoPersonaId).orElseThrow(() -> new ResourceNotFoundException("TipoPersona con ID: "+tipoPersonaId+" no encontrado"));
        Persona entidad = new Persona(
            dto.getId(),
            dto.getNombre(),
            dto.getApellido(),
            dto.getFechaRegistro(),
            sucursal,
            tipoPersona
        );
        Persona entidadGuardada = repository.save(entidad);
        return PersonaMapper.toDto(entidadGuardada);
    }

    @Override
    public PersonaDto getById(String id) {
        Persona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona con el id: " + id + " no encontrado"));
        return PersonaMapper.toDto(entidad);
    }
       

    @Override
    public List<PersonaDto> getAll() {
       List<Persona> entidades = repository.findAll();
       return entidades.stream()
                .map(PersonaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaDto update(String id, PersonaDto updatedDto) {
        Long sucursalId = updatedDto.getSucursal();
        Long tipoPersonaId = updatedDto.getTipoPersona();
        Sucursal sucursal = sucursalRepo.findById(sucursalId).orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID: "+sucursalId+" no encontrado"));
        TipoPersona tipoPersona = tipoPersonaRepo.findById(tipoPersonaId).orElseThrow(() -> new ResourceNotFoundException("TipoPersona con ID: "+tipoPersonaId+" no encontrado"));
        Persona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setApellido(updatedDto.getApellido());
        entidad.setFechaRegistro(updatedDto.getFechaRegistro());
        entidad.setSucursal(sucursal);
        entidad.setTipoPersona(tipoPersona);
        repository.save(entidad);
        return PersonaMapper.toDto(entidad);
    }

    @Override
    public void delete(String id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Persona con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
