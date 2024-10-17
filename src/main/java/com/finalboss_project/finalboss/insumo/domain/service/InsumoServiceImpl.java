package com.finalboss_project.finalboss.insumo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.insumo.domain.repository.IInsumoRepo;
import com.finalboss_project.finalboss.insumo.dto.InsumoDto;
import com.finalboss_project.finalboss.insumo.mapper.InsumoMapper;

@Service
public class InsumoServiceImpl implements IInsumoService {

    @Autowired
    private IInsumoRepo repository;

    @Override
    public InsumoDto create(InsumoDto dto) {
        Insumo entidad = InsumoMapper.toEntity(dto);
        Insumo entidadGuardada = repository.save(entidad);
        return InsumoMapper.toDto(entidadGuardada);
    }

    @Override
    public InsumoDto getById(Long id) {
        Insumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el id: " + id + " no encontrado"));
        return InsumoMapper.toDto(entidad);
    }
       

    @Override
    public List<InsumoDto> getAll() {
       List<Insumo> entidades = repository.findAll();
       return entidades.stream()
                .map(InsumoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public InsumoDto update(Long id, InsumoDto updatedDto) {
        Insumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return InsumoMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
