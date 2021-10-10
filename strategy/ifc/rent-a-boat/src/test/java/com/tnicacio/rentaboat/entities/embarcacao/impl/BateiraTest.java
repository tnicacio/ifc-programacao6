package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BateiraTest {

    private Bateira bateira;

    @BeforeEach
    public void setUp() {
        bateira = new Bateira();
    }

    @Test
    public void shouldReturnMovimentationModeMotor() {
        assertEquals(MovimentationType.MOTOR, bateira.getMovimentationMode());
    }

}
