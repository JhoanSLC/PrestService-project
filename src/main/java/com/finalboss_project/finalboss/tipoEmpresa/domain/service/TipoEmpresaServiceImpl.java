package com.finalboss_project.finalboss.tipoEmpresa.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.tipoEmpresa.domain.entity.TipoEmpresa;
import com.finalboss_project.finalboss.tipoEmpresa.domain.repository.ITipoEmpresaRepository;
import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;
import com.finalboss_project.finalboss.tipoEmpresa.mapper.TipoEmpresaMapper;

import lombok.AllArgsConstructor;

/**
 * Implementación del servicio ITipoEmpresaService.
 * 
 * Proporciona la lógica de negocio para gestionar TipoEmpresa,
 * incluyendo operaciones de creación, búsqueda, actualización 
 * y eliminación. Utiliza el repositorio para acceder a los datos 
 * y un mapper para convertir entre entidades y DTOs.
 */
@Service
@AllArgsConstructor
public class TipoEmpresaServiceImpl implements ITipoEmpresaService {

    private ITipoEmpresaRepository repository;

    @Override
    public TipoEmpresaDto create(TipoEmpresaDto dto) {
        // Convierte el DTO a la entidad TipoEmpresa
        TipoEmpresa entidad = TipoEmpresaMapper.mapToTipoEmpresa(dto);
        // Guarda la entidad en la base de datos
        TipoEmpresa savedEntidad = repository.save(entidad);
        // Devuelve el DTO de la entidad guardada
        return TipoEmpresaMapper.mapToTipoEmpresaDto(savedEntidad);
    }

    @Override
    public TipoEmpresaDto getById(Long id) {
        // Busca la entidad por ID y lanza una excepción si no se encuentra
        TipoEmpresa entidad = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo de empresa con id: " + id + " no encontrado"));
        // Convierte y devuelve el DTO de la entidad encontrada
        return TipoEmpresaMapper.mapToTipoEmpresaDto(entidad);
    }

    @Override
    public List<TipoEmpresaDto> getAll() {
        // Obtiene todas las entidades de TipoEmpresa
        List<TipoEmpresa> entidades = repository.findAll();
        // Convierte la lista de entidades a una lista de DTOs
        return entidades.stream() // Crea un flujo (stream) de la lista
            .map(TipoEmpresaMapper::mapToTipoEmpresaDto) // Mapea cada entidad a su DTO correspondiente
            .collect(Collectors.toList()); // Recoge los resultados en una lista
    }

    @Override
    public TipoEmpresaDto update(Long id, TipoEmpresaDto updatedDto) {
        // Busca la entidad por ID y lanza una excepción si no se encuentra
        TipoEmpresa entidad = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo de empresa con id: " + id + " no encontrado"));
        
        // Actualiza la descripción de la entidad
        entidad.setNombre(updatedDto.getNombre());
        
        // Guarda la entidad actualizada en la base de datos
        TipoEmpresa updatedObj = repository.save(entidad);
        // Devuelve el DTO de la entidad actualizada
        return TipoEmpresaMapper.mapToTipoEmpresaDto(updatedObj);
    }

    @Override
    public void delete(Long id) {
        // Verifica si la entidad existe y lanza una excepción si no se encuentra
        repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Tipo de empresa con id: " + id + " no encontrado"));
        // Elimina la entidad de la base de datos
        repository.deleteById(id);
    }
}
