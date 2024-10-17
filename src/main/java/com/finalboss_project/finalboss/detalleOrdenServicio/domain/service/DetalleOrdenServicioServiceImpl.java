package com.finalboss_project.finalboss.detalleOrdenServicio.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.detalleOrdenServicio.domain.entity.DetalleOrdenServicio;
import com.finalboss_project.finalboss.detalleOrdenServicio.domain.repository.IDetalleOrdenServicioRepository;
import com.finalboss_project.finalboss.detalleOrdenServicio.dto.DetalleOrdenServicioDto;
import com.finalboss_project.finalboss.detalleOrdenServicio.mapper.DetalleOrdenServicioMapper;
import com.finalboss_project.finalboss.ordenServicio.domain.entity.OrdenServicio;
import com.finalboss_project.finalboss.ordenServicio.domain.repository.IOrdenServicioRepo;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;

@Service
public class DetalleOrdenServicioServiceImpl implements IDetalleOrdenServicioService {

    @Autowired
    private IDetalleOrdenServicioRepository repo;

    @Autowired
    private IOrdenServicioRepo ordenServicioRepo;

    @Autowired
    private IServicioRepo servicioRepo;


    @Override
    public DetalleOrdenServicioDto create(DetalleOrdenServicioDto dto) {
        Long ordenServicioId = dto.getOrdenServicioId();
        Long servicioId = dto.getServicioId();

        OrdenServicio ordenServicio = ordenServicioRepo.findById(ordenServicioId).orElseThrow(() -> new ResourceNotFoundException("La ordenServicio con id: "+ordenServicioId+" no encontrada"));
        Servicio servicio = servicioRepo.findById(servicioId).orElseThrow(() -> new ResourceNotFoundException("El servicio con id: "+servicioId+" no encontrado"));

        DetalleOrdenServicio entidad = new DetalleOrdenServicio(
            dto.getId(),
            dto.getValorServicio(),
            ordenServicio,
            servicio
        );
        DetalleOrdenServicio entidadGuardada = repo.save(entidad);
        return DetalleOrdenServicioMapper.toDto(entidadGuardada);
    }

    @Override
    public void delete(Long id) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El DetalleOrdenServicio con id: "+id+" no encontrado"));
        repo.deleteById(id);
        
    }

    @Override
    public List<DetalleOrdenServicioDto> getAll() {
        List<DetalleOrdenServicio> entidades = repo.findAll();
        return entidades.stream()
                .map(DetalleOrdenServicioMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetalleOrdenServicioDto getById(Long id) {
        DetalleOrdenServicio entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El DetalleOrdenServicio con id: "+id+" no encontrado"));
        return DetalleOrdenServicioMapper.toDto(entidad);
    }

    @Override
    public DetalleOrdenServicioDto update(Long id, DetalleOrdenServicioDto updatedDto) {
        DetalleOrdenServicio entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("El DetalleOrdenServicio con id: "+id+" no encontrado"));
        Long ordenServicioId = updatedDto.getOrdenServicioId();
        Long servicioId = updatedDto.getServicioId();

        OrdenServicio ordenServicio = ordenServicioRepo.findById(ordenServicioId).orElseThrow(() -> new ResourceNotFoundException("La ordenServicio con id: "+ordenServicioId+" no encontrada"));
        Servicio servicio = servicioRepo.findById(servicioId).orElseThrow(() -> new ResourceNotFoundException("El servicio con id: "+servicioId+" no encontrado"));
        entidad.setValorServicio(updatedDto.getValorServicio());
        entidad.setServicio(servicio);
        entidad.setOrdenServicio(ordenServicio);
        return DetalleOrdenServicioMapper.toDto(entidad);
    }

}
