package com.finalboss_project.finalboss.rol.infrastructure;

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

import com.finalboss_project.finalboss.rol.domain.service.IRolService;
import com.finalboss_project.finalboss.rol.dto.RolDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/rol")
public class RolController {

    @Autowired
    private IRolService service;

    @PostMapping 
    public ResponseEntity<RolDto> create(@RequestBody RolDto dto) {
        RolDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{rolId}") 
    public ResponseEntity<RolDto> getById(@PathVariable("rolId") Long id) {
        RolDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<RolDto>> getAll() {
        List<RolDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{rolId}") 
    public ResponseEntity<RolDto> update(@PathVariable("rolId") Long id,
                                                 @RequestBody RolDto updated) {
        RolDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{rolId}") 
    public ResponseEntity<String> delete(@PathVariable("rolId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Rol eliminado exitosamente!"); 
    }

}
