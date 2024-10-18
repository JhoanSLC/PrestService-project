package com.finalboss_project.finalboss.tipoTelefono.infrastructure.controller;

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
import com.finalboss_project.finalboss.tipoTelefono.dto.TipoTelefonoDto;
import com.finalboss_project.finalboss.tipoTelefono.domain.service.ITipoTelefonoService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tipoTelefono")
public class TipoTelefonoController {

    @Autowired
    private ITipoTelefonoService service;

    @PostMapping 
    public ResponseEntity<TipoTelefonoDto> create(@RequestBody TipoTelefonoDto dto) {
        TipoTelefonoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{tipoTelefonoId}") 
    public ResponseEntity<TipoTelefonoDto> getById(@PathVariable("tipoTelefonoId") Long id) {
        TipoTelefonoDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<TipoTelefonoDto>> getAll() {
        List<TipoTelefonoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{tipoTelefonoId}") 
    public ResponseEntity<TipoTelefonoDto> update(@PathVariable("tipoTelefonoId") Long id,
                                                 @RequestBody TipoTelefonoDto updated) {
        TipoTelefonoDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{tipoTelefonoId}") 
    public ResponseEntity<String> delete(@PathVariable("tipoTelefonoId") Long id) {
        service.delete(id); 
            return ResponseEntity.ok("¡Tipo Telefono eliminado exitosamente!"); 
    }
}


// TESTEADO Y FUNCIONANDO EN INSOMNIA //
