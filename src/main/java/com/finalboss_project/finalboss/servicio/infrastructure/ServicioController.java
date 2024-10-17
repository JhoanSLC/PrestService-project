package com.finalboss_project.finalboss.servicio.infrastructure;

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

import com.finalboss_project.finalboss.servicio.domain.service.IServicioService;
import com.finalboss_project.finalboss.servicio.dto.ServicioDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    private IServicioService service;

    @PostMapping 
    public ResponseEntity<ServicioDto> create(@RequestBody ServicioDto dto) {
        ServicioDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{servicioId}") 
    public ResponseEntity<ServicioDto> getById(@PathVariable("servicioId") Long id) {
        ServicioDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<ServicioDto>> getAll() {
        List<ServicioDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{servicioId}") 
    public ResponseEntity<ServicioDto> update(@PathVariable("servicioId") Long id,
                                                 @RequestBody ServicioDto updated) {
        ServicioDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{servicioId}") 
    public ResponseEntity<String> delete(@PathVariable("servicioId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Servicio eliminado exitosamente!"); 
    }

}
