package com.finalboss_project.finalboss.tipoEmpresa.infrastructure.controller;

import java.util.List;

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

import com.finalboss_project.finalboss.tipoEmpresa.domain.service.ITipoEmpresaService;
import com.finalboss_project.finalboss.tipoEmpresa.dto.TipoEmpresaDto;

import lombok.AllArgsConstructor;

@CrossOrigin("*") // Permite solicitudes desde cualquier origen (CORS).
@AllArgsConstructor // Genera un constructor con todos los argumentos para la inyección de dependencias.
@RestController // Indica que esta clase es un controlador REST.
@RequestMapping("/api/tipoEmpresa") // Define la ruta base para las solicitudes a este controlador.
public class TipoEmpresaController {

    private ITipoEmpresaService service; // Servicio que maneja la lógica de negocio.

    @PostMapping // Maneja solicitudes POST para crear una nueva TipoEmpresa.
    public ResponseEntity<TipoEmpresaDto> create(@RequestBody TipoEmpresaDto dto) {
        TipoEmpresaDto saved = service.create(dto); // Llama al servicio para crear una nueva entidad.
        return new ResponseEntity<>(saved, HttpStatus.CREATED); // Devuelve la entidad creada con un código de estado 201.
    }

    @GetMapping("{tipoEmpresaId}") // Maneja solicitudes GET para obtener una TipoEmpresa por su ID.
    public ResponseEntity<TipoEmpresaDto> getById(@PathVariable("tipoEmpresaId") Long id) {
        TipoEmpresaDto dto = service.getById(id); // Llama al servicio para obtener la entidad.
        return ResponseEntity.ok(dto); // Devuelve la entidad con un código de estado 200.
    }

    @GetMapping // Maneja solicitudes GET para obtener todas las TipoEmpresa.
    public ResponseEntity<List<TipoEmpresaDto>> getAll() {
        List<TipoEmpresaDto> entidades = service.getAll(); // Llama al servicio para obtener todas las entidades.
        return ResponseEntity.ok(entidades); // Devuelve la lista de entidades con un código de estado 200.
    }

    @PutMapping("{tipoEmpresaId}") // Maneja solicitudes PUT para actualizar una TipoEmpresa por su ID.
    public ResponseEntity<TipoEmpresaDto> update(@PathVariable("tipoEmpresaId") Long id,
                                                 @RequestBody TipoEmpresaDto updated) {
        TipoEmpresaDto dto = service.update(id, updated); // Llama al servicio para actualizar la entidad.
        return ResponseEntity.ok(dto); // Devuelve la entidad actualizada con un código de estado 200.
    }

    @DeleteMapping("{tipoEmpresaId}") // Maneja solicitudes DELETE para eliminar una TipoEmpresa por su ID.
    public ResponseEntity<String> delete(@PathVariable("tipoEmpresaId") Long id) {
        service.delete(id); // Llama al servicio para eliminar la entidad.
        return ResponseEntity.ok("¡Tipo de empresa eliminado exitosamente!"); // Devuelve un mensaje de éxito con un código de estado 200.
    }
}

// TIPO EMPRESA TESTEADO EN INSOMNIA