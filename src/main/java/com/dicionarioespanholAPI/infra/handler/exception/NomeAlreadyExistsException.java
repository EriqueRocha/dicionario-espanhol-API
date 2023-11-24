package com.dicionarioespanholAPI.infra.handler.exception;


public class NomeAlreadyExistsException extends BusinessException{

    public NomeAlreadyExistsException(String campo) {
        super("A palavra '%s' já está cadastrado no sistema","409", "Utilize uma palavra diferente", campo);
    }
}
