package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovimentationVelaTest {

    private MovimentationVela movimentationVela;

    @BeforeEach
    public void setUp() {
        movimentationVela = new MovimentationVela();
    }

    @Test
    public void shouldReturnMovimentationTypeVela() {
        Assertions.assertEquals(MovimentationType.VELA, movimentationVela.movimentationMode());
    }

}