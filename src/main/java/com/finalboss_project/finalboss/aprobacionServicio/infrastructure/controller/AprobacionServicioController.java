package com.finalboss_project.finalboss.aprobacionServicio.infrastructure.controller;


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

import com.finalboss_project.finalboss.aprobacionServicio.domain.service.IAprobacionServicioService;
import com.finalboss_project.finalboss.aprobacionServicio.dto.AprobacionServicioDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/aprobacionServicio")
public class AprobacionServicioController {

    @Autowired
    private IAprobacionServicioService service;

    @PostMapping 
    public ResponseEntity<AprobacionServicioDto> create(@Valid @RequestBody AprobacionServicioDto dto) {
        AprobacionServicioDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{aprobacionServicioId}") 
    public ResponseEntity<AprobacionServicioDto> getById(@PathVariable("aprobacionServicioId") Long id) {
        AprobacionServicioDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<AprobacionServicioDto>> getAll() {
        List<AprobacionServicioDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{aprobacionServicioId}") 
    public ResponseEntity<AprobacionServicioDto> update(@PathVariable("aprobacionServicioId") Long id,
                                                 @RequestBody AprobacionServicioDto updated) {
        AprobacionServicioDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{aprobacionServicioId}") 
    public ResponseEntity<String> delete(@PathVariable("aprobacionServicioId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("AprobacionServicio eliminado exitosamente!"); 
    }
}
