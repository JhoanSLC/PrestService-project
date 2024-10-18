package com.finalboss_project.finalboss.tipoTelefono.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.tipoTelefono.domain.entity.TipoTelefono;
import com.finalboss_project.finalboss.tipoTelefono.domain.repository.ITipoTelefonoRepo;
import com.finalboss_project.finalboss.tipoTelefono.dto.TipoTelefonoDto;
import com.finalboss_project.finalboss.tipoTelefono.mapper.TipoTelefonoMapper;

@Service
public class TipoTelefonoImpl implements ITipoTelefonoService  {

    @Autowired
    private ITipoTelefonoRepo repository;

   @Override
    public TipoTelefonoDto create(TipoTelefonoDto dto) {
        TipoTelefono entidad = TipoTelefonoMapper.toEntity(dto);
        TipoTelefono entidadGuardada = repository.save(entidad);
        return TipoTelefonoMapper.toDto(entidadGuardada);
    }

    @Override
    public TipoTelefonoDto getById(Long id) {
        TipoTelefono entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoTelefono con el id: " + id + " no encontrado"));
        return TipoTelefonoMapper.toDto(entidad);
    }
       

    @Override
    public List<TipoTelefonoDto> getAll() {
       List<TipoTelefono> entidades = repository.findAll();
       return entidades.stream()
                .map(TipoTelefonoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoTelefonoDto update(Long id, TipoTelefonoDto updatedDto) {
        TipoTelefono entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoTelefono con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return TipoTelefonoMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoTelefono con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

    
}
