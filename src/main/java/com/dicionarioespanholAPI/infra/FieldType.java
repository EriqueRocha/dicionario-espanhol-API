package com.dicionarioespanholAPI.infra;

import com.dicionarioespanholAPI.infra.handler.exception.RequiredFieldException;
import com.dicionarioespanholAPI.model.palavra.PalavraResquest;
import org.springframework.stereotype.Service;

@Service
public class FieldType {

    public RequiredFieldException checkData(PalavraResquest request) {
        String[] fields = {
                request.getNome(),
                request.getNomeCientifico(),
                request.getGenero().toString(),
                request.getVarianteLP().toString(),
                request.getEquivalenteLE().toString(),
                request.getVarianteEspanhol().toString(),
                request.getDefinicao(),
                request.getExemplo(),
                request.getResgistroDicionarioLP().toString(),
                request.getResgistroDicionarioLE().toString()
        };
        for (int i = 0; i < fields.length; i++) {
            if (fields[i] == null || fields[i].isEmpty()) {
                return erroType(i + 1);
            }
        }
        return erroType(0);
    }

    public RequiredFieldException erroType(int errorType){
        return switch (errorType) {
            case 1 -> new RequiredFieldException("Palavra, substantivo que dá nome ao objeto");
            case 2 -> new RequiredFieldException("Nome científico");
            case 3 -> new RequiredFieldException("Genero");
            case 4 -> new RequiredFieldException("Variante lingua portuguesa");
            case 5 -> new RequiredFieldException("Equivalente lingua espanhola");
            case 6 -> new RequiredFieldException("Variante lingua espanhola");
            case 7 -> new RequiredFieldException("Definição");
            case 8 -> new RequiredFieldException("exemplo");
            case 9 -> new RequiredFieldException("Resgistro em dicionário português");
            case 10 -> new RequiredFieldException("Resgistro em dicionário espanhol");
            case 0 -> null;
            default -> new RequiredFieldException();
        };
    }
}