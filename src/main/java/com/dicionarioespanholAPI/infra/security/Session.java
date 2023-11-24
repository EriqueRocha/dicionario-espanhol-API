package com.dicionarioespanholAPI.infra.security;

import lombok.Data;

@Data
public class Session {
    private String login;
    private Integer id;
    private String nome;
    private String matricula;
    private String token;

}
