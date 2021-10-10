package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanoaTest {

    private Canoa canoa;

    @BeforeEach
    public void setUp() {
        canoa = new Canoa();
    }

    @Test
    public void shouldReturnMovimentationModeRemos() {
        assertEquals(MovimentationType.REMOS, canoa.getMovimentationMode());
    }

}
