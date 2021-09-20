package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationMotor;

public class Iate extends Embarcacao {

    public Iate() {
        super();
        setMovimentationStrategy(new MovimentationMotor());
    }

}
