package com.finalboss_project.finalboss.empresaServicio.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finalboss_project.finalboss.empresaServicio.domain.service.IEmpresaServicioService;
import com.finalboss_project.finalboss.empresaServicio.dto.EmpresaServicioDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/empresaServicio")
public class EmpresaServicioController {

    @Autowired
    private IEmpresaServicioService service;

    @PostMapping
    public ResponseEntity<EmpresaServicioDto> create(@RequestBody EmpresaServicioDto dto) {
        EmpresaServicioDto saved = service.create(dto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{sucursalId}/{servicioId}")
    public ResponseEntity<EmpresaServicioDto> getById(@PathVariable Long sucursalId, @PathVariable Long servicioId) {
        EmpresaServicioDto dto = service.getById(sucursalId, servicioId);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaServicioDto>> getAll() {
        List<EmpresaServicioDto> entidades = service.getAll();
        return ResponseEntity.ok(entidades);
    }

    @PutMapping("/{sucursalId}/{servicioId}")
    public ResponseEntity<EmpresaServicioDto> update(@PathVariable Long sucursalId, @PathVariable Long servicioId,
            @RequestBody EmpresaServicioDto updatedDto) {
        EmpresaServicioDto dto = service.update(sucursalId, servicioId, updatedDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{sucursalId}/{servicioId}")
    public ResponseEntity<Void> delete(@PathVariable Long sucursalId, @PathVariable Long servicioId) {
        service.delete(sucursalId, servicioId);
        return ResponseEntity.noContent().build();
    }
}
