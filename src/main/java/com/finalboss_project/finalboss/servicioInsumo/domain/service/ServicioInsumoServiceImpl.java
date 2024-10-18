package com.finalboss_project.finalboss.servicioInsumo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.insumo.domain.entity.Insumo;
import com.finalboss_project.finalboss.insumo.domain.repository.IInsumoRepo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumoPk;
import com.finalboss_project.finalboss.servicioInsumo.domain.repository.IServicioInsumoRepo;
import com.finalboss_project.finalboss.servicioInsumo.dto.ServicioInsumoDto;
import com.finalboss_project.finalboss.servicioInsumo.mapper.ServicioInsumoMapper;

@Service
public class ServicioInsumoServiceImpl implements IServicioInsumoService {

    @Autowired
    private IServicioInsumoRepo repository;

    @Autowired
    private IInsumoRepo insumoRepo;

    @Autowired
    private IServicioRepo servicioRepo;

    @Override
    public ServicioInsumoDto create(ServicioInsumoDto dto) {
        Insumo insumo = insumoRepo.findById(dto.getInsumoId())
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el ID: " + dto.getInsumoId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(dto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el ID: " + dto.getServicioId() + " no encontrado"));
        ServicioInsumo entidad = ServicioInsumoMapper.toEntity(dto);
        entidad.setInsumo(insumo);
        entidad.setServicio(servicio);
        ServicioInsumo entidadGuardada = repository.save(entidad);
        return ServicioInsumoMapper.toDto(entidadGuardada);
    }

    @Override
    public ServicioInsumoDto getById(Long insumoId, Long servicioId) {
        ServicioInsumoPk id = new ServicioInsumoPk(insumoId, servicioId);
        ServicioInsumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServicioInsumo no encontrado"));
        return ServicioInsumoMapper.toDto(entidad);
    }

    @Override
    public List<ServicioInsumoDto> getAll() {
        List<ServicioInsumo> entidades = repository.findAll();
        return entidades.stream().map(ServicioInsumoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ServicioInsumoDto update(Long insumoId, Long servicioId, ServicioInsumoDto updatedDto) {
        ServicioInsumoPk id = new ServicioInsumoPk(insumoId, servicioId);
        ServicioInsumo entidad = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServicioInsumo no encontrado"));

        // Validar los insumos y servicios
        Insumo insumo = insumoRepo.findById(updatedDto.getInsumoId())
                .orElseThrow(() -> new ResourceNotFoundException("Insumo con el ID: " + updatedDto.getInsumoId() + " no encontrado"));
        Servicio servicio = servicioRepo.findById(updatedDto.getServicioId())
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con el ID: " + updatedDto.getServicioId() + " no encontrado"));

        // Actualizar entidad
        entidad.setValorUnitario(updatedDto.getValorUnitario());
        entidad.setStock(updatedDto.getStock());
        entidad.setStockMin(updatedDto.getStockMin());
        entidad.setStockMax(updatedDto.getStockMax());
        entidad.setInsumo(insumo);
        entidad.setServicio(servicio);

        // Guardar y retornar
        return ServicioInsumoMapper.toDto(repository.save(entidad));
    }

    @Override
    public void delete(Long insumoId, Long servicioId) {
        ServicioInsumoPk id = new ServicioInsumoPk(insumoId, servicioId);
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ServicioInsumo no encontrado"));
        repository.deleteById(id);
    }
}
