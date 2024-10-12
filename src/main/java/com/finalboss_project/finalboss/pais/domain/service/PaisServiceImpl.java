package com.finalboss_project.finalboss.pais.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.pais.domain.entity.Pais;
import com.finalboss_project.finalboss.pais.domain.repository.IPaisRepository;
import com.finalboss_project.finalboss.pais.dto.PaisDto;
import com.finalboss_project.finalboss.pais.mapper.PaisMapper;

@Service
public class PaisServiceImpl implements IPaisService{

    @Autowired
    private IPaisRepository repository;

    @Override
    public PaisDto create(PaisDto dto) {
        Pais entidad = PaisMapper.toEntity(dto);
        Pais entidadGuardada = repository.save(entidad);
        return PaisMapper.toDto(entidadGuardada);
    }

    @Override
    public PaisDto getById(Long id) {
        Pais entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pais con el id: " + id + " no encontrado"));
        return PaisMapper.toDto(entidad);
    }
       

    @Override
    public List<PaisDto> getAll() {
       List<Pais> entidades = repository.findAll();
       return entidades.stream()
                .map(PaisMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaisDto update(Long id, PaisDto updatedDto) {
        Pais entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pais con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return PaisMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pais con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
