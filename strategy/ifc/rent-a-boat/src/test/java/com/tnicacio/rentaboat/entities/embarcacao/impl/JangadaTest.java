package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JangadaTest {

    private Jangada jangada;

    @BeforeEach
    public void setUp() {
        jangada = new Jangada();
    }

    @Test
    public void shouldReturnMovimentationModeRemos() {
        assertEquals(MovimentationType.REMOS, jangada.getMovimentationMode());
    }

}
