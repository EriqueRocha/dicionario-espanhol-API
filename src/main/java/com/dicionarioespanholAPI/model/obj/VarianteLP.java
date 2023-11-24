package com.dicionarioespanholAPI.model.obj;

import com.dicionarioespanholAPI.enums.DicionarioLP;
import com.dicionarioespanholAPI.enums.Genero;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Embeddable
@Data
public class VarianteLP {

    private String nome;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private List<DicionarioLP> dicionarioLP;

}
