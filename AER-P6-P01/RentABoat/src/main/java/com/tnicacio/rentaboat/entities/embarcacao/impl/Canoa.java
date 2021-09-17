package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationRemos;

public class Canoa extends Embarcacao {

    public Canoa() {
        super();
        setMovimentationStrategy(new MovimentationRemos());
    }

}
