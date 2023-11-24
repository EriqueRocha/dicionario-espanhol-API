package com.dicionarioespanholAPI.model.obj;

import com.dicionarioespanholAPI.enums.DicionarioLE;
import com.dicionarioespanholAPI.enums.Presenca;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class ResgistroDicionarioLE {

    @Enumerated(EnumType.STRING)
    private DicionarioLE dicionarioLE;

    @Enumerated(EnumType.STRING)
    private Presenca presenca;

}
