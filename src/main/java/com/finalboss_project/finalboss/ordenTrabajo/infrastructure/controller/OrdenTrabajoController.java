package com.finalboss_project.finalboss.ordenTrabajo.infrastructure.controller;

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

import com.finalboss_project.finalboss.ordenTrabajo.domain.service.IOrdenTrabajoService;
import com.finalboss_project.finalboss.ordenTrabajo.dto.OrdenTrabajoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ordenTrabajo")
public class OrdenTrabajoController {

    @Autowired
    private IOrdenTrabajoService service;

    @PostMapping 
    public ResponseEntity<OrdenTrabajoDto> create(@RequestBody OrdenTrabajoDto dto) {
        OrdenTrabajoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{ordenTrabajoId}") 
    public ResponseEntity<OrdenTrabajoDto> getById(@PathVariable("ordenTrabajoId") Long id) {
        OrdenTrabajoDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<OrdenTrabajoDto>> getAll() {
        List<OrdenTrabajoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{ordenTrabajoId}") 
    public ResponseEntity<OrdenTrabajoDto> update(@PathVariable("ordenTrabajoId") Long id,
                                                 @RequestBody OrdenTrabajoDto updated) {
        OrdenTrabajoDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{ordenTrabajoId}") 
    public ResponseEntity<String> delete(@PathVariable("ordenTrabajoId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡OrdenTrabajo eliminado exitosamente!"); 
    }

}
