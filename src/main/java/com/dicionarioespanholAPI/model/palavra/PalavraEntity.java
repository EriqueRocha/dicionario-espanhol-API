package com.dicionarioespanholAPI.model.palavra;

import com.dicionarioespanholAPI.enums.*;
import com.dicionarioespanholAPI.model.obj.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class PalavraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String nomeCientifico;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<VarianteLP> varianteLP;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<EquivalenteLE> equivalenteLE;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<VarianteEspanhol> varianteEspanhol;

    @Column(length = 500)
    private String definicao;

    private String exemplo;

    private String notaContrastiva;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ResgistroDicionarioLP> resgistroDicionarioLP;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<ResgistroDicionarioLE> resgistroDicionarioLE;

    @Column
    @ElementCollection
    private List<String> imagePaths;

}
