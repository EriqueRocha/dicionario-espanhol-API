package com.dicionarioespanholAPI.model.obj;

import com.dicionarioespanholAPI.enums.DicionarioLP;
import com.dicionarioespanholAPI.enums.Presenca;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class ResgistroDicionarioLP {

    @Enumerated(EnumType.STRING)
    private DicionarioLP dicionarioLP;

    @Enumerated(EnumType.STRING)
    private Presenca presenca;

}
