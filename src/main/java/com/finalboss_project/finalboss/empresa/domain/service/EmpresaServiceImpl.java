package com.finalboss_project.finalboss.empresa.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.empresa.domain.entity.Empresa;
import com.finalboss_project.finalboss.empresa.domain.repository.IEmpresaRepository;
import com.finalboss_project.finalboss.empresa.dto.EmpresaDto;
import com.finalboss_project.finalboss.empresa.mapper.EmpresaMapper;
import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;
import com.finalboss_project.finalboss.tipoEmpresa.domain.repository.ITipoEmpresaRepository;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

    @Autowired
    private IEmpresaRepository repository;

    @Autowired
    private ITipoEmpresaRepository tipoEmpresaRepository;

    @Override
    public EmpresaDto create(EmpresaDto dto) {
        Long tipoEmpresaId = dto.getTipoEmpresaId();

        TipoEmpresa tipoEmpresa = tipoEmpresaRepository.findById(tipoEmpresaId)
                .orElseThrow(() -> new ResourceNotFoundException("TipoEmpresa con id: " + tipoEmpresaId + " no encontrado"));
        
        
        Empresa entidad = new Empresa(
            dto.getId(),
            dto.getNombre(),
            tipoEmpresa
        );
        Empresa entidadGuardada = repository.save(entidad);
        return EmpresaMapper.toEmpresaDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa con id: " + id + " No encontrado"));
        repository.deleteById(id);
    }

    @Override
    public List<EmpresaDto> getAll() {
        List<Empresa> entidades = repository.findAll();
        return entidades.stream()
                .map(EmpresaMapper::toEmpresaDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmpresaDto getById(Long id) {
        Empresa entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa con id: " + id + " no encontrada"));
        return EmpresaMapper.toEmpresaDto(entidad);
    }

    @Override
    public EmpresaDto update(Long id, EmpresaDto updatedDto) {
        Empresa entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa con id: " + id + " no encontrada"));
        TipoEmpresa tipoEmpresa = tipoEmpresaRepository.findById(updatedDto.getTipoEmpresaId())
                .orElseThrow(() -> new ResourceNotFoundException("TipoEmpresa con id: " + updatedDto.getTipoEmpresaId() + " no encontrado"));
        entidad.setNombre(updatedDto.getNombre());
        entidad.setTipoEmpresa(tipoEmpresa);
        repository.save(entidad);
        return EmpresaMapper.toEmpresaDto(entidad);
    }
}
