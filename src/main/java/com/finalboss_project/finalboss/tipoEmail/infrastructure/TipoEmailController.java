package com.finalboss_project.finalboss.tipoEmail.infrastructure;

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
import com.finalboss_project.finalboss.tipoEmail.domain.service.ITipoEmailService;
import com.finalboss_project.finalboss.tipoEmail.dto.TipoEmailDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/pais")
public class TipoEmailController {

    @Autowired
    private ITipoEmailService service;

    @PostMapping 
    public ResponseEntity<TipoEmailDto> create(@RequestBody TipoEmailDto dto) {
        TipoEmailDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{tipoEmailId}") 
    public ResponseEntity<TipoEmailDto> getById(@PathVariable("tipoEmailId") Long id) {
        TipoEmailDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<TipoEmailDto>> getAll() {
        List<TipoEmailDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{tipoEmailId}") 
    public ResponseEntity<TipoEmailDto> update(@PathVariable("tipoEmailId") Long id,
                                                 @RequestBody TipoEmailDto updated) {
        TipoEmailDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{tipoEmailId}") 
    public ResponseEntity<String> delete(@PathVariable("tipoEmailId") Long id) {
        service.delete(id);
            return ResponseEntity.ok("¡Tipo Email eliminado exitosamente!"); 
    }

}
