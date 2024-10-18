package com.finalboss_project.finalboss.tipoPersona.infrastructure.controller;

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

import com.finalboss_project.finalboss.tipoPersona.domain.service.ITipoPersonaService;
import com.finalboss_project.finalboss.tipoPersona.dto.TipoPersonaDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoPersona")
public class TipoPersonaController {

    @Autowired
    private ITipoPersonaService service;

    @PostMapping 
    public ResponseEntity<TipoPersonaDto> create(@RequestBody TipoPersonaDto dto) {
        TipoPersonaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{tipoPersonaId}") 
    public ResponseEntity<TipoPersonaDto> getById(@PathVariable("tipoPersonaId") Long id) {
        TipoPersonaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<TipoPersonaDto>> getAll() {
        List<TipoPersonaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{tipoPersonaId}") 
    public ResponseEntity<TipoPersonaDto> update(@PathVariable("tipoPersonaId") Long id,
                                                 @RequestBody TipoPersonaDto updated) {
        TipoPersonaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{tipoPersonaId}") 
    public ResponseEntity<String> delete(@PathVariable("tipoPersonaId") Long id) {
        service.delete(id); 
            return ResponseEntity.ok("¡Tipo Persona eliminado exitosamente!"); 
    }

}

// TIPO PERSONA TESTEADO EN INSOMNIA