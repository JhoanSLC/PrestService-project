package com.finalboss_project.finalboss.direccion.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.ciudad.domain.repository.ICiudadRepository;
import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.direccion.domain.entity.Direccion;
import com.finalboss_project.finalboss.direccion.domain.repository.IDireccionRepository;
import com.finalboss_project.finalboss.direccion.dto.DireccionDto;
import com.finalboss_project.finalboss.direccion.mapper.DireccionMapper;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.sucursal.domain.repository.ISucursalRepo;

@Service
public class DireccionServiceImpl implements IDireccionService{

    @Autowired
    private IDireccionRepository repo;

    @Autowired
    private ICiudadRepository ciudadRepo;

    @Autowired
    private ISucursalRepo sucursalRepo;

    @Override
    public DireccionDto create(DireccionDto dto) {
        Ciudad ciudad = ciudadRepo.findById(dto.getCiudadId()).orElseThrow(() -> new ResourceNotFoundException("Ciudad con el ID: "+dto.getCiudadId()+" no encontrado"));
        Sucursal sucursal = sucursalRepo.findById(dto.getSucursalId()).orElseThrow(() -> new ResourceNotFoundException("Sucursal con el ID: "+dto.getSucursalId()+" no encontrado"));

        Direccion entidad = new Direccion(
            dto.getId(),
            dto.getCalle(),
            dto.getCarrera(),
            dto.getDescripcion(),
            dto.getBarrio(),
            ciudad,
            sucursal
        );
        Direccion entidadGuardada = repo.save(entidad);
        return DireccionMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Direccion con ID: "+id+" no encontrada"));
        repo.deleteById(id);
        
    }

    @Override
    public List<DireccionDto> getAll() {
        List<Direccion> entidades = repo.findAll();
        return entidades.stream()
                .map(DireccionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DireccionDto getById(Long id) {
        Direccion entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Direccion con ID: "+id+" no encontrada"));
        return DireccionMapper.toDto(entidad);
    }

    @Override
    public DireccionDto update(Long id, DireccionDto updatedDto) {
        Direccion entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Direccion con ID: "+id+" no encontrada"));
        Ciudad ciudad = ciudadRepo.findById(updatedDto.getCiudadId()).orElseThrow(() -> new ResourceNotFoundException("Ciudad con el ID: "+updatedDto.getCiudadId()+" no encontrado"));
        Sucursal sucursal = sucursalRepo.findById(updatedDto.getSucursalId()).orElseThrow(() -> new ResourceNotFoundException("Sucursal con el ID: "+updatedDto.getSucursalId()+" no encontrado"));
        entidad.setBarrio(updatedDto.getBarrio());
        entidad.setCalle(updatedDto.getCalle());
        entidad.setCarrera(updatedDto.getCarrera());
        entidad.setCiudad(ciudad);
        entidad.setDescripcion(updatedDto.getDescripcion());
        entidad.setSucursal(sucursal);
        repo.save(entidad);
        return DireccionMapper.toDto(entidad);
    }

}
