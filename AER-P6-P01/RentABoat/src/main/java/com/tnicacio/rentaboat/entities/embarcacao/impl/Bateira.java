package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationMotor;

public class Bateira extends Embarcacao {

    public Bateira() {
        super();
        setMovimentationStrategy(new MovimentationMotor());
    }

}
