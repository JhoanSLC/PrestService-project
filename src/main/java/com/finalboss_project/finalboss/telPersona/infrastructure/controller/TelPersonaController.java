package com.finalboss_project.finalboss.telPersona.infrastructure.controller;

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

import com.finalboss_project.finalboss.telPersona.domain.service.ITelPersonaService;
import com.finalboss_project.finalboss.telPersona.dto.TelPersonaDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/telPersona")
public class TelPersonaController {

    @Autowired
    private ITelPersonaService service;

    @PostMapping 
    public ResponseEntity<TelPersonaDto> create(@RequestBody TelPersonaDto dto) {
        TelPersonaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{telPersonaId}") 
    public ResponseEntity<TelPersonaDto> getById(@PathVariable("telPersonaId") Long id) {
        TelPersonaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<TelPersonaDto>> getAll() {
        List<TelPersonaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{telPersonaId}") 
    public ResponseEntity<TelPersonaDto> update(@PathVariable("telPersonaId") Long id,
                                                 @RequestBody TelPersonaDto updated) {
        TelPersonaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{telPersonaId}") 
    public ResponseEntity<String> delete(@PathVariable("telPersonaId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡TelPersona eliminado exitosamente!"); 
    }

}
