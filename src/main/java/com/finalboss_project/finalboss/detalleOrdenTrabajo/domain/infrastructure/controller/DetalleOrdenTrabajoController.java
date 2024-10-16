package com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.infrastructure.controller;

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

import com.finalboss_project.finalboss.detalleOrdenTrabajo.domain.service.IDetalleOrdenTrabajoService;
import com.finalboss_project.finalboss.detalleOrdenTrabajo.dto.DetalleOrdenTrabajoDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/detalleOrdenTrabajo")
public class DetalleOrdenTrabajoController {

    @Autowired
    private IDetalleOrdenTrabajoService service;

    @PostMapping 
    public ResponseEntity<DetalleOrdenTrabajoDto> create(@Valid @RequestBody DetalleOrdenTrabajoDto dto) {
        DetalleOrdenTrabajoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{detalleOrdenTrabajoId}") 
    public ResponseEntity<DetalleOrdenTrabajoDto> getById(@PathVariable("detalleOrdenTrabajoId") Long id) {
        DetalleOrdenTrabajoDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<DetalleOrdenTrabajoDto>> getAll() {
        List<DetalleOrdenTrabajoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{detalleOrdenTrabajoId}") 
    public ResponseEntity<DetalleOrdenTrabajoDto> update(@PathVariable("detalleOrdenTrabajoId") Long id,
                                                 @RequestBody DetalleOrdenTrabajoDto updated) {
        DetalleOrdenTrabajoDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{detalleOrdenTrabajoId}") 
    public ResponseEntity<String> delete(@PathVariable("detalleOrdenTrabajoId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡DetalleOrdenTrabajo eliminado exitosamente!"); 
    }
}
