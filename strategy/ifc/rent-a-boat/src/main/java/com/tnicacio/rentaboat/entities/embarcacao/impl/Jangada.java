package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationRemos;

public class Jangada extends Embarcacao {

    public Jangada() {
        super();
        setMovimentationStrategy(new MovimentationRemos());
    }

}
