package com.finalboss_project.finalboss.direccion.infrastructure.controller;

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

import com.finalboss_project.finalboss.direccion.domain.service.IDireccionService;
import com.finalboss_project.finalboss.direccion.dto.DireccionDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/direccion")
public class DireccionController {

    @Autowired
    private IDireccionService service;

    @PostMapping 
    public ResponseEntity<DireccionDto> create(@Valid @RequestBody DireccionDto dto) {
        DireccionDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{direccionId}") 
    public ResponseEntity<DireccionDto> getById(@PathVariable("direccionId") Long id) {
        DireccionDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<DireccionDto>> getAll() {
        List<DireccionDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{direccionId}") 
    public ResponseEntity<DireccionDto> update(@PathVariable("direccionId") Long id,
                                                 @RequestBody DireccionDto updated) {
        DireccionDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{direccionId}") 
    public ResponseEntity<String> delete(@PathVariable("direccionId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡Direccion eliminada exitosamente!"); 
    }
}
