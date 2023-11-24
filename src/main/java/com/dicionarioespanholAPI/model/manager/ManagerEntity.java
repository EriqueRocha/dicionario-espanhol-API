package com.dicionarioespanholAPI.model.manager;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tab_manager")
public class ManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String matricula;

    private String nome;

    private String email;

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String role = "MANAGER";



}
