package com.dicionarioespanholAPI.model.obj;

import com.dicionarioespanholAPI.enums.DicionarioLE;
import com.dicionarioespanholAPI.enums.Genero;
import com.dicionarioespanholAPI.enums.Paises;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class VarianteEspanhol {

    private String palavra;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Enumerated(EnumType.STRING)
    private DicionarioLE dicionarioLE;

    @Enumerated(EnumType.STRING)
    private List<Paises> paises;

}
