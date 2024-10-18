package com.finalboss_project.finalboss.tipoPersona.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.tipoPersona.domain.entity.TipoPersona;
import com.finalboss_project.finalboss.tipoPersona.domain.repository.ITipoPersonaRepo;
import com.finalboss_project.finalboss.tipoPersona.dto.TipoPersonaDto;
import com.finalboss_project.finalboss.tipoPersona.mapper.TipoPersonaMapper;

@Service
public class TipoPersonaServiceImpl implements ITipoPersonaService {

    @Autowired
    private ITipoPersonaRepo repository;

    @Override
    public TipoPersonaDto create(TipoPersonaDto dto) {
        TipoPersona entidad = TipoPersonaMapper.toEntity(dto);
        TipoPersona entidadGuardada = repository.save(entidad);
        return TipoPersonaMapper.toDto(entidadGuardada);
    }

    @Override
    public TipoPersonaDto getById(Long id) {
        TipoPersona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoPersona con el id: " + id + " no encontrado"));
        return TipoPersonaMapper.toDto(entidad);
    }
       

    @Override
    public List<TipoPersonaDto> getAll() {
       List<TipoPersona> entidades = repository.findAll();
       return entidades.stream()
                .map(TipoPersonaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoPersonaDto update(Long id, TipoPersonaDto updatedDto) {
        TipoPersona entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoPersona con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return TipoPersonaMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoPersona con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }
    
}
