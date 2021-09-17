package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarcoAVelaTest {

    private BarcoAVela barcoAVela;

    @BeforeEach
    public void setUp() {
        barcoAVela = new BarcoAVela();
    }

    @Test
    public void shouldReturnMovimentationModeRemos() {
        assertEquals(MovimentationType.VELA, barcoAVela.getMovimentationMode());
    }

}
