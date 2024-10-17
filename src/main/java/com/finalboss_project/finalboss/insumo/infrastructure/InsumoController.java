package com.finalboss_project.finalboss.insumo.infrastructure;

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

import com.finalboss_project.finalboss.insumo.domain.service.IInsumoService;
import com.finalboss_project.finalboss.insumo.dto.InsumoDto;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/insumo")
public class InsumoController {

    @Autowired
    private IInsumoService service;

    @PostMapping 
    public ResponseEntity<InsumoDto> create(@RequestBody InsumoDto dto) {
        InsumoDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{insumoId}") 
    public ResponseEntity<InsumoDto> getById(@PathVariable("insumoId") Long id) {
        InsumoDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<InsumoDto>> getAll() {
        List<InsumoDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{insumoId}") 
    public ResponseEntity<InsumoDto> update(@PathVariable("insumoId") Long id,
                                                 @RequestBody InsumoDto updated) {
        InsumoDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{insumoId}") 
    public ResponseEntity<String> delete(@PathVariable("insumoId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Insumo eliminado exitosamente!"); 
    }

}
