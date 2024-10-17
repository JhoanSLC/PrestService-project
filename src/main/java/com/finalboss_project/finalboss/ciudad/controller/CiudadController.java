package com.finalboss_project.finalboss.ciudad.controller;

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

import com.finalboss_project.finalboss.ciudad.domain.service.ICiudadService;
import com.finalboss_project.finalboss.ciudad.dto.EstadoAprobacionDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {

    @Autowired
    private ICiudadService service;

    @PostMapping 
    public ResponseEntity<EstadoAprobacionDto> create(@Valid @RequestBody EstadoAprobacionDto dto) {
        EstadoAprobacionDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{ciudadId}") 
    public ResponseEntity<EstadoAprobacionDto> getById(@PathVariable("ciudadId") Long id) {
        EstadoAprobacionDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<EstadoAprobacionDto>> getAll() {
        List<EstadoAprobacionDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{ciudadId}") 
    public ResponseEntity<EstadoAprobacionDto> update(@PathVariable("ciudadId") Long id,
                                                 @RequestBody EstadoAprobacionDto updated) {
        EstadoAprobacionDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{ciudadId}") 
    public ResponseEntity<String> delete(@PathVariable("ciudadId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡Ciudad eliminada exitosamente!"); 
    }
}
