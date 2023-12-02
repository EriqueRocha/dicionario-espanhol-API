package com.dicionarioespanholAPI.model.manager;

import lombok.Data;

@Data
public class ManagerRequest {

    private String matricula;

    private String nome;

    private String email;

    private String password;
}
