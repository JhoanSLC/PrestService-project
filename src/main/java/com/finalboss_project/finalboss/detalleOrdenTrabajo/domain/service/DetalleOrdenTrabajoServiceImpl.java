package com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.entity.DetalleOrdenTrabajo;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.repository.IDetalleOrdenTrabajoRepo;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.dto.DetalleOrdenTrabajoDto;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.mapper.DetalleOrdenTrabajoMapper;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.entity.EstadoOrdenTrabajo;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.repository.IEstadoOrdenTrabajoRepo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.entity.OrdenTrabajo;
import com.finalboss_project.finalboss.ordenTrabajo.domain.repository.IOrdenTrabajoRepository;
import com.finalboss_project.finalboss.servicio.domain.entity.Servicio;
import com.finalboss_project.finalboss.servicio.domain.repository.IServicioRepo;

@Service
public class DetalleOrdenTrabajoServiceImpl implements IDetalleOrdenTrabajoService {

    @Autowired
    private IDetalleOrdenTrabajoRepo detalleOrdenTrabajoRepo;

    @Autowired
    private IOrdenTrabajoRepository ordenTrabajoRepo;

    @Autowired
    private IServicioRepo servicioRepo;

    @Autowired
    private IEstadoOrdenTrabajoRepo estadoOrdenTrabajoRepo;

    @Override
    public DetalleOrdenTrabajoDto create(DetalleOrdenTrabajoDto dto) {
        Long ordenTrabajoId = dto.getEstadoOrdenTrabajoId();
        Long servicioId = dto.getServicioId();
        Long estadoId = dto.getEstadoOrdenTrabajoId();

        OrdenTrabajo ordenTrabajo = ordenTrabajoRepo.findById(ordenTrabajoId)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con id: " + ordenTrabajoId + " no encontrado"));

        Servicio servicio = servicioRepo.findById(servicioId)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con id: " + servicioId + " no encontrado"));

        EstadoOrdenTrabajo estado = estadoOrdenTrabajoRepo.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenTrabajo con id: " + estadoId + " no encontrado"));

        DetalleOrdenTrabajo entidad = new DetalleOrdenTrabajo(
            dto.getId(),
            ordenTrabajo,
            servicio,
            dto.getFecha(),
            estado
        );
        DetalleOrdenTrabajo entidadGuardada = detalleOrdenTrabajoRepo.save(entidad);
        return DetalleOrdenTrabajoMapper.toDto(entidadGuardada);
    }

    @Override
    public DetalleOrdenTrabajoDto getById(Long id) {
        DetalleOrdenTrabajo entidad = detalleOrdenTrabajoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenTrabajo con id: " + id + " no encontrada"));
        return DetalleOrdenTrabajoMapper.toDto(entidad);
    }

    @Override
    public List<DetalleOrdenTrabajoDto> getAll() {
        List<DetalleOrdenTrabajo> entidades = detalleOrdenTrabajoRepo.findAll();
        return entidades.stream()
                .map(DetalleOrdenTrabajoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DetalleOrdenTrabajoDto update(Long id, DetalleOrdenTrabajoDto updatedDto) {
        DetalleOrdenTrabajo entidad = detalleOrdenTrabajoRepo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenTrabajo con id: "+id+" no encontrado"));
        
        Long ordenTrabajoId = updatedDto.getEstadoOrdenTrabajoId();
        Long servicioId = updatedDto.getServicioId();
        Long estadoId = updatedDto.getEstadoOrdenTrabajoId();

        OrdenTrabajo ordenTrabajo = ordenTrabajoRepo.findById(ordenTrabajoId)
                .orElseThrow(() -> new ResourceNotFoundException("OrdenTrabajo con id: " + ordenTrabajoId + " no encontrado"));

        Servicio servicio = servicioRepo.findById(servicioId)
                .orElseThrow(() -> new ResourceNotFoundException("Servicio con id: " + servicioId + " no encontrado"));

        EstadoOrdenTrabajo estado = estadoOrdenTrabajoRepo.findById(estadoId)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoOrdenTrabajo con id: " + estadoId + " no encontrado"));
        
        entidad.setEstadoOrdenTrabajo(estado);
        entidad.setFecha(updatedDto.getFecha());
        entidad.setOrdenTrabajo(ordenTrabajo);
        entidad.setServicio(servicio);
        return DetalleOrdenTrabajoMapper.toDto(entidad);
    }

    @Override
    public void delete(Long id) {
        detalleOrdenTrabajoRepo.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenTrabajo con id: "+id+" no encontrado"));
        detalleOrdenTrabajoRepo.deleteById(id);
    }

}
