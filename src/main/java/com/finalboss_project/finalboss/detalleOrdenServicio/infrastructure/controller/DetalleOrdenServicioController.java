package com.finalboss_project.finalboss.detalleOrdenServicio.infrastructure.controller;

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

import com.finalboss_project.finalboss.detalleOrdenServicio.domain.service.IDetalleOrdenServicioService;
import com.finalboss_project.finalboss.detalleOrdenServicio.dto.DetalleOrdenServicioDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/detalleOrdenServicio")
public class DetalleOrdenServicioController {

    @Autowired
    private IDetalleOrdenServicioService service;

    @PostMapping 
    public ResponseEntity<DetalleOrdenServicioDto> create(@Valid @RequestBody DetalleOrdenServicioDto dto) {
        DetalleOrdenServicioDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{detalleOrdenServicioId}") 
    public ResponseEntity<DetalleOrdenServicioDto> getById(@PathVariable("detalleOrdenServicioId") Long id) {
        DetalleOrdenServicioDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<DetalleOrdenServicioDto>> getAll() {
        List<DetalleOrdenServicioDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{detalleOrdenServicioId}") 
    public ResponseEntity<DetalleOrdenServicioDto> update(@PathVariable("detalleOrdenServicioId") Long id,
                                                 @RequestBody DetalleOrdenServicioDto updated) {
        DetalleOrdenServicioDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{detalleOrdenServicioId}") 
    public ResponseEntity<String> delete(@PathVariable("detalleOrdenServicioId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡DetalleOrdenServicio eliminado exitosamente!"); 
    }
}
