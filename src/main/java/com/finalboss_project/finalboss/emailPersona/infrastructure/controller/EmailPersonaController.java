package com.finalboss_project.finalboss.emailPersona.infrastructure.controller;

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
import com.finalboss_project.finalboss.emailPersona.domain.service.IEmailPersonaService;
import com.finalboss_project.finalboss.emailPersona.dto.EmailPersonaDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/direccion")
public class EmailPersonaController {

    @Autowired
    private IEmailPersonaService service;

    @PostMapping 
    public ResponseEntity<EmailPersonaDto> create(@Valid @RequestBody EmailPersonaDto dto) {
        EmailPersonaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{emailPersonaId}") 
    public ResponseEntity<EmailPersonaDto> getById(@PathVariable("emailPersonaId") Long id) {
        EmailPersonaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<EmailPersonaDto>> getAll() {
        List<EmailPersonaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{emailPersonaId}") 
    public ResponseEntity<EmailPersonaDto> update(@PathVariable("emailPersonaId") Long id,
                                                 @RequestBody EmailPersonaDto updated) {
        EmailPersonaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{emailPersonaId}") 
    public ResponseEntity<String> delete(@PathVariable("emailPersonaId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡EmailPersona eliminado exitosamente!"); 
    }
}
