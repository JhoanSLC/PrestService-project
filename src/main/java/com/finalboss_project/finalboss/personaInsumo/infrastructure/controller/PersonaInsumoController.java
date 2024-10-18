package com.finalboss_project.finalboss.personaInsumo.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finalboss_project.finalboss.personaInsumo.domain.service.IPersonaInsumoService;
import com.finalboss_project.finalboss.personaInsumo.dto.PersonaInsumoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/personaInsumo")
public class PersonaInsumoController {

    @Autowired
    private IPersonaInsumoService service;

    @PostMapping
    public ResponseEntity<PersonaInsumoDto> create(@RequestBody PersonaInsumoDto dto) {
        PersonaInsumoDto saved = service.create(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{personaId}/{insumoId}")
    public ResponseEntity<PersonaInsumoDto> getById(@PathVariable String personaId, @PathVariable Long insumoId) {
        PersonaInsumoDto dto = service.getById(personaId, insumoId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PersonaInsumoDto>> getAll() {
        List<PersonaInsumoDto> entidades = service.getAll();
        return ResponseEntity.ok(entidades);
    }

    @PutMapping("/{personaId}/{insumoId}")
    public ResponseEntity<PersonaInsumoDto> update(@PathVariable String personaId, @PathVariable Long insumoId,
            @RequestBody PersonaInsumoDto updatedDto) {
        PersonaInsumoDto dto = service.update(personaId, insumoId, updatedDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{personaId}/{insumoId}")
    public ResponseEntity<Void> delete(@PathVariable String personaId, @PathVariable Long insumoId) {
        service.delete(personaId, insumoId);
        return ResponseEntity.noContent().build();
    }
}
