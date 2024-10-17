package com.finalboss_project.finalboss.estadoOrdenServicio.infrastructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalboss_project.finalboss.estadoOrdenServicio.domain.service.IEstadoOrdenServicioService;
import com.finalboss_project.finalboss.estadoOrdenServicio.dto.EstadoOrdenServicioDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/estadoOrdenServicio")
public class EstadoOrdenServicioController {

    @Autowired
    private IEstadoOrdenServicioService service;

    @PostMapping 
    public ResponseEntity<EstadoOrdenServicioDto> create(@Valid @RequestBody EstadoOrdenServicioDto dto) {
        EstadoOrdenServicioDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{estadoOrdenServicioId}") 
    public ResponseEntity<EstadoOrdenServicioDto> getById(@PathVariable("estadoOrdenServicioId") Long id) {
        EstadoOrdenServicioDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<EstadoOrdenServicioDto>> getAll() {
        List<EstadoOrdenServicioDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{estadoOrdenServicioId}") 
    public ResponseEntity<EstadoOrdenServicioDto> update(@PathVariable("estadoOrdenServicioId") Long id,
                                                 @RequestBody EstadoOrdenServicioDto updated) {
        EstadoOrdenServicioDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{estadoOrdenServicioId}") 
    public ResponseEntity<String> delete(@PathVariable("estadoOrdenServicioId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡EstadoOrdenServicio eliminado exitosamente!"); 
    }
}
