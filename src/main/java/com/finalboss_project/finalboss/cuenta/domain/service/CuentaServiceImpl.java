package com.finalboss_project.finalboss.cuenta.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.cuenta.domain.entity.Cuenta;
import com.finalboss_project.finalboss.cuenta.domain.repository.ICuentaRepository;
import com.finalboss_project.finalboss.cuenta.dto.CuentaDto;
import com.finalboss_project.finalboss.cuenta.mapper.CuentaMapper;
import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.rol.domain.entity.Rol;
import com.finalboss_project.finalboss.rol.domain.repository.IRolRepository;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaRepository cuentaRepo;

    @Autowired
    private IRolRepository rolRepo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Override
    public CuentaDto create(CuentaDto dto) {
        Long rolId = dto.getRolId();
        String personaId = dto.getPersonaId();

        Rol rol = rolRepo.findById(rolId).orElseThrow(() -> new ResourceNotFoundException("Rol con el id: "+rolId+" no encontrado"));
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con el id: "+personaId+" no encontrada"));

        Cuenta entidad = new Cuenta(
            dto.getId(),
            dto.getUsuario(),
            dto.getContraseña(),
            rol,
            persona
        );
        Cuenta entidadGuardada = cuentaRepo.save(entidad);
        return CuentaMapper.toDto(entidadGuardada);
    }

    @Override
    public CuentaDto getById(Long id) {
        Cuenta entidad = cuentaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuenta con el id: "+id+" no encontrado"));
        return CuentaMapper.toDto(entidad);
    }

    @Override
    public List<CuentaDto> getAll() {
        List<Cuenta> entidades = cuentaRepo.findAll();
        return entidades.stream()
                .map(CuentaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CuentaDto update(Long id, CuentaDto updatedDto) {
        Cuenta entidad = cuentaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuenta con el id: "+id+" no encontrado"));
        Long rolId = updatedDto.getRolId();
        String personaId = updatedDto.getPersonaId();

        Rol rol = rolRepo.findById(rolId).orElseThrow(() -> new ResourceNotFoundException("Rol con el id: "+rolId+" no encontrado"));
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con el id: "+personaId+" no encontrada"));

        entidad.setUsuario(updatedDto.getUsuario());
        entidad.setContraseña(updatedDto.getContraseña());
        entidad.setPersona(persona);
        entidad.setRol(rol);
        return CuentaMapper.toDto(entidad);
       
    }

    @Override
    public void delete(Long id) {
        cuentaRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cuenta con el id: "+id+" no encontrado"));
        cuentaRepo.deleteById(id);
    }

}
