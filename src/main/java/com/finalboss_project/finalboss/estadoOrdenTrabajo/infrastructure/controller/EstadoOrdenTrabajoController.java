package com.finalboss_project.finalboss.estadoOrdenTrabajo.infrastructure.controller;

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

import com.finalboss_project.finalboss.estadoOrdenTrabajo.domain.service.IEstadoOrdenTrabajoService;
import com.finalboss_project.finalboss.estadoOrdenTrabajo.dto.EstadoOrdenTrabajoDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/estadoOrdenTrabajo")
public class EstadoOrdenTrabajoController {

    @Autowired
    private IEstadoOrdenTrabajoService service;

    @PostMapping 
    public ResponseEntity<EstadoOrdenTrabajoDto> create(@Valid @RequestBody EstadoOrdenTrabajoDto dto) {
        EstadoOrdenTrabajoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{estadoOrdenTrabajoId}") 
    public ResponseEntity<EstadoOrdenTrabajoDto> getById(@PathVariable("estadoOrdenTrabajoId") Long id) {
        EstadoOrdenTrabajoDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<EstadoOrdenTrabajoDto>> getAll() {
        List<EstadoOrdenTrabajoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{estadoOrdenTrabajoId}") 
    public ResponseEntity<EstadoOrdenTrabajoDto> update(@PathVariable("estadoOrdenTrabajoId") Long id,
                                                 @RequestBody EstadoOrdenTrabajoDto updated) {
        EstadoOrdenTrabajoDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{estadoOrdenTrabajoId}") 
    public ResponseEntity<String> delete(@PathVariable("estadoOrdenTrabajoId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡EstadoOrdenTrabajo eliminado exitosamente!"); 
    }
}
