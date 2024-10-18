package com.finalboss_project.finalboss.empresaServicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicio;
import com.finalboss_project.finalboss.empresaServicio.domain.entity.EmpresaServicioPk;
import com.finalboss_project.finalboss.empresaServicio.domain.repository.IEmpresaServicioRepository;
import com.finalboss_project.finalboss.empresaServicio.dto.EmpresaServicioDto;
import com.finalboss_project.finalboss.empresaServicio.mapper.EmpresaServicioMapper;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;
import com.finalboss_project.finalboss.sucursal.domain.entity.Sucursal;
import com.finalboss_project.finalboss.sucursal.domain.repository.ISucursalRepo;

@Service
public class EmpresaServicioServiceImpl implements IEmpresaServicioService {

    @Autowired
    private IEmpresaServicioRepository repository;

    @Autowired
    private ISucursalRepo sucursalRepo;

    @Autowired
    private IServicioRepo servicioRepo;

    @Override
    public EmpresaServicioDto create(EmpresaServicioDto dto) {
        Sucursal sucursal = sucursalRepo.findById(dto.getSucursalId())
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID: " + dto.getSucursalId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(dto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con ID: " + dto.getServicioId() + " no encontrado"));

        EmpresaServicio entidad = EmpresaServicioMapper.toEntity(dto);
        entidad.setSucursal(sucursal);
        entidad.setServicio(servicio);

        EmpresaServicio entidadGuardada = repository.save(entidad);
        return EmpresaServicioMapper.toDto(entidadGuardada);
    }

    @Override
    public EmpresaServicioDto getById(Long sucursalId, Long servicioId) {
        EmpresaServicioPk id = new EmpresaServicioPk(sucursalId, servicioId);
        EmpresaServicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpresaServicio no encontrado"));
        return EmpresaServicioMapper.toDto(entidad);
    }

    @Override
    public List<EmpresaServicioDto> getAll() {
        List<EmpresaServicio> entidades = repository.findAll();
        return entidades.stream().map(EmpresaServicioMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmpresaServicioDto update(Long sucursalId, Long servicioId, EmpresaServicioDto updatedDto) {
        EmpresaServicioPk id = new EmpresaServicioPk(sucursalId, servicioId);
        EmpresaServicio entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpresaServicio no encontrado"));

        Sucursal sucursal = sucursalRepo.findById(updatedDto.getSucursalId())
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal con ID: " + updatedDto.getSucursalId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(updatedDto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con ID: " + updatedDto.getServicioId() + " no encontrado"));

        entidad.setSucursal(sucursal);
        entidad.setServicio(servicio);
        entidad.setValorServicio(updatedDto.getValorServicio());

        return EmpresaServicioMapper.toDto(repository.save(entidad));
    }

    @Override
    public void delete(Long sucursalId, Long servicioId) {
        EmpresaServicioPk id = new EmpresaServicioPk(sucursalId, servicioId);
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EmpresaServicio no encontrado"));
        repository.deleteById(id);
    }
}
