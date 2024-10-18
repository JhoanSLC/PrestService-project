package com.finalboss_project.finalboss.sucursal.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.direccion.domain.repository.IDireccionRepository;
import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;
import com.finalboss_project.finalboss.empresa.domain.repository.IEmpresaRepository;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.sucursal.domain.repository.ISucursalRepo;
import com.finalboss_project.finalboss.sucursal.dto.SucursalDto;
import com.finalboss_project.finalboss.sucursal.mapper.SucursalMapper;

@Service
public class SucursalServiceImpl implements ISucursalService {

    @Autowired
    private ISucursalRepo repository;

    @Autowired
    private IDireccionRepository direccionRepo;

    @Autowired
    private IEmpresaRepository empresaRepo;

    @Override
    public SucursalDto create(SucursalDto dto) {
        Long direccionId = dto.getDireccion();
        Long empresaId = dto.getEmpresa();
        Direccion direccion = direccionRepo.findById(direccionId).orElseThrow(() -> new ResourceNotFoundException("Direccion con ID: "+direccionId+" no encontrado"));
        Empresa empresa = empresaRepo.findById(empresaId).orElseThrow(() -> new ResourceNotFoundException("Empresa con ID: "+empresaId+" no encontrada"));
        Sucursal entidad = new Sucursal(
            dto.getId(),
            dto.getNombre(),
            dto.getNit(),
            dto.getFechaCreacion(),
            direccion,
            empresa
        );
        Sucursal entidadGuardada = repository.save(entidad);
        return SucursalMapper.toDto(entidadGuardada);
    }

    @Override
    public SucursalDto getById(Long id) {
        Sucursal entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con el id: " + id + " no encontrado"));
        return SucursalMapper.toDto(entidad);
    }
       

    @Override
    public List<SucursalDto> getAll() {
       List<Sucursal> entidades = repository.findAll();
       return entidades.stream()
                .map(SucursalMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SucursalDto update(Long id, SucursalDto updatedDto) {
        Long direccionId = updatedDto.getDireccion();
        Long empresaId = updatedDto.getEmpresa();
        Direccion direccion = direccionRepo.findById(direccionId).orElseThrow(() -> new ResourceNotFoundException("Direccion con ID: "+direccionId+" no encontrado"));
        Empresa empresa = empresaRepo.findById(empresaId).orElseThrow(() -> new ResourceNotFoundException("Empresa con ID: "+empresaId+" no encontrada"));
        Sucursal entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con el id: " + id + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setDireccion(direccion);
        entidad.setEmpresa(empresa);
        entidad.setFechaCreacion(updatedDto.getFechaCreacion());
        entidad.setNit(updatedDto.getNit());
        repository.save(entidad);
        return SucursalMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con el id: " + id + " no encontrado"));
        repository.deleteById(id);
    }

}
