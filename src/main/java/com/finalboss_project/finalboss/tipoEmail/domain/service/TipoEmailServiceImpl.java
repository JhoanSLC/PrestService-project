package com.finalboss_project.finalboss.tipoEmail.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.tipoEmail.domain.entity.TipoEmail;
import com.finalboss_project.finalboss.tipoEmail.domain.repository.ITipoEmailRepo;
import com.finalboss_project.finalboss.tipoEmail.dto.TipoEmailDto;
import com.finalboss_project.finalboss.tipoEmail.mapper.TipoEmailMapper;

@Service
public class TipoEmailServiceImpl implements ITipoEmailService{

    @Autowired
    private ITipoEmailRepo repository;


    @Override
    public TipoEmailDto create(TipoEmailDto dto) {
        TipoEmail entidad = TipoEmailMapper.toEntity(dto);
        TipoEmail entidadGuardada = repository.save(entidad);
        return TipoEmailMapper.toDto(entidadGuardada);
    }

    @Override
    public TipoEmailDto getById(Long id) {
        TipoEmail entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoEmail con el id: " + id + " no encontrado"));
        return TipoEmailMapper.toDto(entidad);
    }
       

    @Override
    public List<TipoEmailDto> getAll() {
       List<TipoEmail> entidades = repository.findAll();
       return entidades.stream()
                .map(TipoEmailMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TipoEmailDto update(Long id, TipoEmailDto updatedDto) {
        TipoEmail entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoEmail con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return TipoEmailMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TipoEmail con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
