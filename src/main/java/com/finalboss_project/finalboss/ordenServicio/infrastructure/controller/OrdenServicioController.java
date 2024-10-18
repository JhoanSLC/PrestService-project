package com.finalboss_project.finalboss.ordenServicio.infrastructure.controller;

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

import com.finalboss_project.finalboss.ordenServicio.domain.service.IOrdenServicioService;
import com.finalboss_project.finalboss.ordenServicio.dto.OrdenServicioDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ordenServicio")
public class OrdenServicioController {

    @Autowired
    private IOrdenServicioService service;

    @PostMapping 
    public ResponseEntity<OrdenServicioDto> create(@RequestBody OrdenServicioDto dto) {
        OrdenServicioDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{ordenServicioId}") 
    public ResponseEntity<OrdenServicioDto> getById(@PathVariable("ordenServicioId") Long id) {
        OrdenServicioDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<OrdenServicioDto>> getAll() {
        List<OrdenServicioDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{ordenServicioId}") 
    public ResponseEntity<OrdenServicioDto> update(@PathVariable("ordenServicioId") Long id,
                                                 @RequestBody OrdenServicioDto updated) {
        OrdenServicioDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{ordenServicioId}") 
    public ResponseEntity<String> delete(@PathVariable("ordenServicioId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡OrdenServicio eliminado exitosamente!"); 
    }

}
