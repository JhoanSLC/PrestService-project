package com.finalboss_project.finalboss.region.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.pais.domain.entity.Pais;
import com.finalboss_project.finalboss.pais.domain.repository.IPaisRepository;
import com.finalboss_project.finalboss.region.domain.entity.Region;
import com.finalboss_project.finalboss.region.domain.repository.IRegionRepository;
import com.finalboss_project.finalboss.region.dto.RegionDto;
import com.finalboss_project.finalboss.region.mapper.RegionMapper;

@Service
public class RegionServiceImpl implements IRegionService{

    @Autowired
    private IRegionRepository repository;

    @Autowired
    private IPaisRepository repository2;

    @Override
    public RegionDto create(RegionDto dto) {
        Pais pais =repository2.findById(dto.getPaisId())
            .orElseThrow(() -> new ResourceNotFoundException("El país con id: " + dto.getPaisId() + " no fue encontrado"));
        
        Region entidad = new Region(
            dto.getId(),
            dto.getNombre(),
            pais
        );
        Region entidadGuardada = repository.save(entidad);
        return RegionMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region con id: " + id + " No encontrado"));
        repository.deleteById(id);
    }

    @Override
    public List<RegionDto> getAll() {
        List<Region> entidades = repository.findAll();
        return entidades.stream()
                .map(RegionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RegionDto getById(Long id) {
        Region entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region con id: " + id + " no encontrada"));
        return RegionMapper.toDto(entidad);
    }

    @Override
    public RegionDto update(Long id, RegionDto updatedDto) {
        Region entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region con id: " + id + " no encontrada"));

        Pais pais = repository2.findById(updatedDto.getPaisId())
                .orElseThrow(() -> new ResourceNotFoundException("El país con id: " + updatedDto.getPaisId() + " no fue encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setPais(pais);
        repository.save(entidad);
        return RegionMapper.toDto(entidad);
    }

}
