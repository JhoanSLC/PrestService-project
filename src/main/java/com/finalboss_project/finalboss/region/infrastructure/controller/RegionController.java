package com.finalboss_project.finalboss.region.infrastructure.controller;

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

import com.finalboss_project.finalboss.region.domain.service.IRegionService;
import com.finalboss_project.finalboss.region.dto.RegionDto;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/region")
public class RegionController {

    @Autowired
    private IRegionService service;

    @PostMapping 
    public ResponseEntity<RegionDto> create(@RequestBody RegionDto dto) {
        RegionDto saved = service.create(dto); 
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("{regionId}") 
    public ResponseEntity<RegionDto> getById(@PathVariable("regionId") Long id) {
        RegionDto dto = service.getById(id); 
        return ResponseEntity.ok(dto);
    }

    @GetMapping 
    public ResponseEntity<List<RegionDto>> getAll() {
        List<RegionDto> entidades = service.getAll(); 
        return ResponseEntity.ok(entidades); 
    }

    @PutMapping("{regionId}") 
    public ResponseEntity<RegionDto> update(@PathVariable("regionId") Long id,
                                                 @RequestBody RegionDto updated) {
        RegionDto dto = service.update(id, updated); 
        return ResponseEntity.ok(dto); 
    }

    @DeleteMapping("{regionId}") 
    public ResponseEntity<String> delete(@PathVariable("regionId") Long id) {
        service.delete(id); 
        return ResponseEntity.ok("Region eliminado exitosamente!"); 
    }

}
