package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;

public class MovimentationMotor implements MovimentationStrategy {

    @Override
    public MovimentationType movimentationMode() {
        return MovimentationType.MOTOR;
    }

}
