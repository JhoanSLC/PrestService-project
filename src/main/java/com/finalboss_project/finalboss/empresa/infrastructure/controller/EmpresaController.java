package com.finalboss_project.finalboss.empresa.infrastructure.controller;

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

import com.finalboss_project.finalboss.empresa.domain.service.IEmpresaService;
import com.finalboss_project.finalboss.empresa.dto.EmpresaDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {

    @Autowired
    private IEmpresaService service;

    @PostMapping 
    public ResponseEntity<EmpresaDto> create(@RequestBody EmpresaDto dto) {
        EmpresaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{empresaId}") 
    public ResponseEntity<EmpresaDto> getById(@PathVariable("empresaId") Long id) {
        EmpresaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<EmpresaDto>> getAll() {
        List<EmpresaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{empresaId}") 
    public ResponseEntity<EmpresaDto> update(@PathVariable("empresaId") Long id,
                                                 @RequestBody EmpresaDto updated) {
        EmpresaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{empresaId}") 
    public ResponseEntity<String> delete(@PathVariable("empresaId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("¡Empresa eliminada exitosamente!"); 
    }

}
