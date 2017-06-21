package com.apsi.logic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Client already exist!")
public class ClientAlreadyExistsException extends Exception{

    public ClientAlreadyExistsException(String s) {
        super(s);
    }
}
