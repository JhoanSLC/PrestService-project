package com.finalboss_project.finalboss.emailPersona.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalboss_project.finalboss.customExceptions.ResourceNotFoundException;
import com.finalboss_project.finalboss.emailPersona.domain.entity.EmailPersona;
import com.finalboss_project.finalboss.emailPersona.domain.repository.IEmailPersonaRepository;
import com.finalboss_project.finalboss.emailPersona.dto.EmailPersonaDto;
import com.finalboss_project.finalboss.emailPersona.mapper.EmailPersonaMapper;
import com.finalboss_project.finalboss.persona.domain.entity.Persona;
import com.finalboss_project.finalboss.persona.domain.repository.IPersonaRepo;
import com.finalboss_project.finalboss.tipoEmail.domain.entity.TipoEmail;
import com.finalboss_project.finalboss.tipoEmail.domain.repository.ITipoEmailRepo;

@Service
public class EmailPersonaServiceImpl implements IEmailPersonaService {

    @Autowired
    private IEmailPersonaRepository repo;

    @Autowired
    private IPersonaRepo personaRepo;

    @Autowired
    private ITipoEmailRepo tipoEmailRepo;

    @Override
    public EmailPersonaDto create(EmailPersonaDto dto) {
        String personaId = dto.getPersonaId();
        Long tipoEmailId = dto.getTipoEmailId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+personaId+" no encontrada"));
        TipoEmail tipoEmail = tipoEmailRepo.findById(tipoEmailId).orElseThrow(() -> new ResourceNotFoundException("TipoEmail con el ID: "+tipoEmailId+" no encontrado"));
        EmailPersona entidad = new EmailPersona(
            dto.getId(),
            dto.getEmail(),
            persona,
            tipoEmail
        );
        EmailPersona entidadGuardada = repo.save(entidad);
        return EmailPersonaMapper.toDto(entidadGuardada);
    }

    @Override
    public EmailPersonaDto getById(Long id) {
        EmailPersona entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmailPersona con el ID: "+id+" no encontrado"));
        return EmailPersonaMapper.toDto(entidad);
    }

    @Override
    public List<EmailPersonaDto> getAll() {
        List<EmailPersona> entidades = repo.findAll();
        return entidades.stream().map(EmailPersonaMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmailPersonaDto update(Long id, EmailPersonaDto updatedDto) {
        String personaId = updatedDto.getPersonaId();
        Long tipoEmailId = updatedDto.getTipoEmailId();
        Persona persona = personaRepo.findById(personaId).orElseThrow(() -> new ResourceNotFoundException("Persona con el ID: "+personaId+" no encontrada"));
        TipoEmail tipoEmail = tipoEmailRepo.findById(tipoEmailId).orElseThrow(() -> new ResourceNotFoundException("TipoEmail con el ID: "+tipoEmailId+" no encontrado"));
        EmailPersona entidad = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmailPersona con el ID: "+id+" no encontrado"));
        entidad.setEmail(updatedDto.getEmail());
        entidad.setPersona(persona);
        entidad.setTipoEmail(tipoEmail);
        repo.save(entidad);
        return EmailPersonaMapper.toDto(entidad);

    }

    @Override
    public void delete(Long id) {
        repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("EmailPersona con el ID: "+id+" no encontrado"));
        repo.deleteById(id);
    }

}
