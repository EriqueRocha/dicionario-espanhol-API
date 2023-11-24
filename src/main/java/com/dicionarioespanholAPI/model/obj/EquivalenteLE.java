package com.dicionarioespanholAPI.model.obj;

import com.dicionarioespanholAPI.enums.Genero;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;


@Embeddable
@Data
public class EquivalenteLE {

    private String nome;

    @Enumerated(EnumType.STRING)
    private Genero genero;
}
