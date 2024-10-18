package com.finalboss_project.finalboss.persona.infrastructure;

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

import com.finalboss_project.finalboss.persona.domain.service.IPersonaService;
import com.finalboss_project.finalboss.persona.dto.PersonaDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @PostMapping 
    public ResponseEntity<PersonaDto> create(@RequestBody PersonaDto dto) {
        PersonaDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{personaId}") 
    public ResponseEntity<PersonaDto> getById(@PathVariable("personaId") String id) {
        PersonaDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<PersonaDto>> getAll() {
        List<PersonaDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{personaId}") 
    public ResponseEntity<PersonaDto> update(@PathVariable("personaId") String id,
                                                 @RequestBody PersonaDto updated) {
        PersonaDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{personaId}") 
    public ResponseEntity<String> delete(@PathVariable("personaId") String id) {
        service.delete(id);
            return ResponseEntity.ok("¡Persona eliminado exitosamente!"); 
    }

}
