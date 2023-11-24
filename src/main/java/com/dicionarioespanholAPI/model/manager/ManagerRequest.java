package com.dicionarioespanholAPI.model.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ManagerRequest {

    private String matricula;

    private String nome;

    private String email;

    private String password;

    @JsonIgnore
    private String role = "MANAGER";
}
