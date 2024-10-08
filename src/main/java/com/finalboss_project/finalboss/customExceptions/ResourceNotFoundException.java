package com.finalboss_project.finalboss.customExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    
    // Este constructor recibe el mensaje personalizado que se va a mostrar
    // al usuario en el momento de que se haga una petición y la respuesta sea
    // que no se encontró la petición
    public ResourceNotFoundException(String mensaje){
        super(mensaje);
    }
}
