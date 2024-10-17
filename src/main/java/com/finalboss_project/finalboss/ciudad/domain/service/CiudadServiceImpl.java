package com.finalboss_project.finalboss.ciudad.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.ciudad.domain.entity.Ciudad;
import com.finalboss_project.finalboss.ciudad.domain.repository.ICiudadRepository;
import com.finalboss_project.finalboss.ciudad.dto.EstadoAprobacionDto;
import com.finalboss_project.finalboss.ciudad.mapper.CiudadMapper;
import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.region.domain.entity.Region;
import com.finalboss_project.finalboss.region.domain.repository.IRegionRepository;

@Service
public class CiudadServiceImpl implements ICiudadService {

    @Autowired
    private ICiudadRepository repository;

    @Autowired
    private IRegionRepository regionRepo;

    @Override
    public EstadoAprobacionDto create(EstadoAprobacionDto dto) {
        Long relacionId = dto.getRegionId();

        Region entidadRelacionada = regionRepo.findById(relacionId)
                .orElseThrow(() -> new ResourceNotFoundException("Region con id: " + relacionId + " no encontrado"));
        
        
        Ciudad entidad = new Ciudad(
            dto.getId(),
            dto.getNombre(),
            entidadRelacionada
        );
        Ciudad entidadGuardada = repository.save(entidad);
        return CiudadMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad con id: " + id + " No encontrado"));
        repository.deleteById(id);
    }

    @Override
    public List<EstadoAprobacionDto> getAll() {
        List<Ciudad> entidades = repository.findAll();
        return entidades.stream()
                .map(CiudadMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoAprobacionDto getById(Long id) {
        Ciudad entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad con id: " + id + " no encontrada"));
        return CiudadMapper.toDto(entidad);
    }

    @Override
    public EstadoAprobacionDto update(Long id, EstadoAprobacionDto updatedDto) {
        Ciudad entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ciudad con id: " + id + " no encontrada"));
        Region region = regionRepo.findById(updatedDto.getRegionId())
                .orElseThrow(() -> new ResourceNotFoundException("Region con id: " + updatedDto.getRegionId() + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setRegion(region);
        repository.save(entidad);
        return CiudadMapper.toDto(entidad);
    }

}
