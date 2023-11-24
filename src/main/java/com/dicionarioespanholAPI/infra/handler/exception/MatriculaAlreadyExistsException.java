package com.dicionarioespanholAPI.infra.handler.exception;


public class MatriculaAlreadyExistsException extends BusinessException{

    public MatriculaAlreadyExistsException(String campo) {
        super("A matricula '%s' já está cadastrada no sistema","409", "Utilize uma matricula diferente", campo);
    }
}
