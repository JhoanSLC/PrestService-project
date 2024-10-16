package com.finalboss_project.finalboss.tipoTelefono.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.finalboss_project.finalboss.tipoTelefono.domain.repository.ITipoTelefonoRepo;
import com.finalboss_project.finalboss.tipoTelefono.dto.TipoTelefonoDto;

public class TipoTelefonoImpl implements ITipoTelefonoService  {

    @Autowired
    private ITipoTelefonoRepo repository;

    @Override
    public TipoTelefonoDto create(TipoTelefonoDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public TipoTelefonoDto getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<TipoTelefonoDto> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public TipoTelefonoDto update(Long id, TipoTelefonoDto updatedDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    
}
