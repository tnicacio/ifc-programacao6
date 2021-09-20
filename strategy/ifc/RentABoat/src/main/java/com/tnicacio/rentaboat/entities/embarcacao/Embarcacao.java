package com.tnicacio.rentaboat.entities.embarcacao;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationStrategy;

public abstract class Embarcacao {

    MovimentationStrategy movimentationStrategy;

    public void setMovimentationStrategy(MovimentationStrategy movimentationStrategy) {
        this.movimentationStrategy = movimentationStrategy;
    }

    public MovimentationType getMovimentationMode() {
        return movimentationStrategy.movimentationMode();
    }

}
