package com.finalboss_project.finalboss.cuenta.infrastructure.controller;

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

import com.finalboss_project.finalboss.cuenta.domain.service.ICuentaService;
import com.finalboss_project.finalboss.cuenta.dto.CuentaDto;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/cuenta")
public class CuentaController {

    @Autowired
    private ICuentaService service;

    @PostMapping 
    public ResponseEntity<CuentaDto> create(@Valid @RequestBody CuentaDto dto) {
        CuentaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{cuentaId}") 
    public ResponseEntity<CuentaDto> getById(@PathVariable("cuentaId") Long id) {
        CuentaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<CuentaDto>> getAll() {
        List<CuentaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{cuentaId}") 
    public ResponseEntity<CuentaDto> update(@PathVariable("cuentaId") Long id,
                                                 @RequestBody CuentaDto updated) {
        CuentaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{cuentaId}") 
    public ResponseEntity<String> delete(@PathVariable("cuentaId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡Cuenta eliminada exitosamente!"); 
    }
}
