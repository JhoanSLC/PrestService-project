package com.finalboss_project.finalboss.pais.infrastructure.controller;

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

import com.finalboss_project.finalboss.pais.domain.service.IPaisService;
import com.finalboss_project.finalboss.pais.dto.PaisDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private IPaisService service;

    @PostMapping 
    public ResponseEntity<PaisDto> create(@RequestBody PaisDto dto) {
        PaisDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{paisId}") 
    public ResponseEntity<PaisDto> getById(@PathVariable("paisId") Long id) {
        PaisDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<PaisDto>> getAll() {
        List<PaisDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{paisId}") 
    public ResponseEntity<PaisDto> update(@PathVariable("paisId") Long id,
                                                 @RequestBody PaisDto updated) {
        PaisDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{paisId}") 
    public ResponseEntity<String> delete(@PathVariable("paisId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Pais eliminado exitosamente!"); 
    }

}
