package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;

public class MovimentationVela implements MovimentationStrategy {

    @Override
    public MovimentationType movimentationMode() {
        return MovimentationType.VELA;
    }

}
