package com.tnicacio.rentaboat.strategies.movimentationstrategy;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;

public class MovimentationRemos implements MovimentationStrategy {

    @Override
    public MovimentationType movimentationMode() {
        return MovimentationType.REMOS;
    }

}
