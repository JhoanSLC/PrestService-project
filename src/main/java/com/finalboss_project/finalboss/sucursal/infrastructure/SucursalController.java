package com.finalboss_project.finalboss.sucursal.infrastructure;

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

import com.finalboss_project.finalboss.sucursal.domain.service.ISucursalService;
import com.finalboss_project.finalboss.sucursal.dto.SucursalDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sucursal")
public class SucursalController {

    @Autowired
    private ISucursalService service;

    @PostMapping 
    public ResponseEntity<SucursalDto> create(@RequestBody SucursalDto dto) {
        SucursalDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{sucursalId}") 
    public ResponseEntity<SucursalDto> getById(@PathVariable("sucursalId") Long id) {
        SucursalDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<SucursalDto>> getAll() {
        List<SucursalDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{sucursalId}") 
    public ResponseEntity<SucursalDto> update(@PathVariable("sucursalId") Long id,
                                                 @RequestBody SucursalDto updated) {
        SucursalDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{sucursalId}") 
    public ResponseEntity<String> delete(@PathVariable("sucursalId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Sucursal eliminado exitosamente!"); 
    }

}
