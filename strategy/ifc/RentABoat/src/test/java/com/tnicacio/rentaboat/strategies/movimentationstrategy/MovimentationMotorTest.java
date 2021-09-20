package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovimentationMotorTest {

    private MovimentationMotor movimentationMotor;

    @BeforeEach
    public void setUp() {
        movimentationMotor = new MovimentationMotor();
    }

    @Test
    public void shouldReturnMovimentationTypeMotor() {
        Assertions.assertEquals(MovimentationType.MOTOR, movimentationMotor.movimentationMode());
    }

}