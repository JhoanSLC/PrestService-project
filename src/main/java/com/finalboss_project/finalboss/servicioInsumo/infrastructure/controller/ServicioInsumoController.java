package com.finalboss_project.finalboss.servicioInsumo.infrastructure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finalboss_project.finalboss.servicioInsumo.domain.service.IServicioInsumoService;
import com.finalboss_project.finalboss.servicioInsumo.dto.ServicioInsumoDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/servicioInsumo")
public class ServicioInsumoController {

    @Autowired
    private IServicioInsumoService service;

    @PostMapping 
    public ResponseEntity<ServicioInsumoDto> create(@RequestBody ServicioInsumoDto dto) {
        ServicioInsumoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{insumoId}/{servicioId}") 
    public ResponseEntity<ServicioInsumoDto> getById(@PathVariable Long insumoId, @PathVariable Long servicioId) {
        ServicioInsumoDto dto = service.getById(insumoId, servicioId); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<ServicioInsumoDto>> getAll() {
        List<ServicioInsumoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{insumoId}/{servicioId}") 
    public ResponseEntity<ServicioInsumoDto> update(@PathVariable Long insumoId, @PathVariable Long servicioId,
                                                    @RequestBody ServicioInsumoDto updated) {
        ServicioInsumoDto dto = service.update(insumoId, servicioId, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{insumoId}/{servicioId}") 
    public ResponseEntity<String> delete(@PathVariable Long insumoId, @PathVariable Long servicioId) {
        service.delete(insumoId, servicioId);
        return ResponseEntity.ok("¡ServicioInsumo eliminado exitosamente!"); 
    }
}
