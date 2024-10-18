package com.finalboss_project.finalboss.rol.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.rol.domain.entity.Rol;
import com.finalboss_project.finalboss.rol.domain.repository.IRolRepository;
import com.finalboss_project.finalboss.rol.dto.RolDto;
import com.finalboss_project.finalboss.rol.mapper.RolMapper;

@Service
public class RolServiceImpl implements IRolService {

    @Autowired
    private IRolRepository repository;

    @Override
    public RolDto create(RolDto dto) {
        Rol entidad = RolMapper.toEntity(dto);
        Rol entidadGuardada = repository.save(entidad);
        return RolMapper.toDto(entidadGuardada);
    }

    @Override
    public RolDto getById(Long id) {
        Rol entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol con el id: " + id + " no encontrado"));
        return RolMapper.toDto(entidad);
    }
       

    @Override
    public List<RolDto> getAll() {
       List<Rol> entidades = repository.findAll();
       return entidades.stream()
                .map(RolMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RolDto update(Long id, RolDto updatedDto) {
        Rol entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        repository.save(entidad);
        return RolMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rol con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }


}
