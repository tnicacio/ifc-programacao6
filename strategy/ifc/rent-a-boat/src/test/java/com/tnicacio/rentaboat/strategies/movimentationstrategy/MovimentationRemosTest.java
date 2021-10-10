package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovimentationRemosTest {

    private MovimentationRemos movimentationRemos;

    @BeforeEach
    public void setUp() {
        movimentationRemos = new MovimentationRemos();
    }

    @Test
    public void shouldReturnMovimentationTypeRemos() {
        Assertions.assertEquals(MovimentationType.REMOS, movimentationRemos.movimentationMode());
    }

}