package com.dicionarioespanholAPI.model.palavra;

import com.dicionarioespanholAPI.enums.*;
import com.dicionarioespanholAPI.model.obj.*;
import lombok.Data;

import java.util.List;

@Data
public class PalavraResquest {

    private String nome;

    private String nomeCientifico;

    private Genero genero;

    private List<VarianteLP> varianteLP;

    private List<EquivalenteLE> equivalenteLE;

    private List<VarianteEspanhol> varianteEspanhol;

    private String definicao;

    private String exemplo;

    private String notaContrastiva;

    private List<ResgistroDicionarioLP> resgistroDicionarioLP;

    private List<ResgistroDicionarioLE> resgistroDicionarioLE;

}
