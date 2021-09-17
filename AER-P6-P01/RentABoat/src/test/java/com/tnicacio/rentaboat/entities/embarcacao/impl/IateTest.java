package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IateTest {

    private Iate iate;

    @BeforeEach
    public void setUp() {
        iate = new Iate();
    }

    @Test
    public void shouldReturnMovimentationModeRemos() {
        assertEquals(MovimentationType.MOTOR, iate.getMovimentationMode());
    }

}
