package com.finalboss_project.finalboss.emailPersona.domain.service;

import java.util.List;

import com.finalboss_project.finalboss.emailPersona.dto.EmailPersonaDto;

public interface IEmailPersonaService {

    EmailPersonaDto create(EmailPersonaDto dto);
    EmailPersonaDto getById(Long id);
    List<EmailPersonaDto> getAll();
    EmailPersonaDto update(Long id, EmailPersonaDto updatedDto);
    void delete(Long id);

}
