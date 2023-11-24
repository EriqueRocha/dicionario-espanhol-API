package com.dicionarioespanholAPI.infra.handler.exception;


public class EmailAlreadyExistsException extends BusinessException{

    public EmailAlreadyExistsException(String campo) {
        super("O email '%s' já está cadastrado no sistema","409", "Utilize um email diferente", campo);
    }
}
