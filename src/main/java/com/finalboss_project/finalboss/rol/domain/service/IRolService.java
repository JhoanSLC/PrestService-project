package com.finalboss_project.finalboss.rol.domain.service;

import java.util.List;
import com.finalboss_project.finalboss.rol.dto.RolDto;

public interface IRolService {

    RolDto create(RolDto dto);
    RolDto getById(Long id);
    List<RolDto> getAll();
    RolDto update(Long id, RolDto updatedDto);
    void delete(Long id);

}
