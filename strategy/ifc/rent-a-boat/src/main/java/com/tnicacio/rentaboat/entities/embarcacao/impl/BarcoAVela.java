package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.strategies.movimentationstrategy.MovimentationVela;

public class BarcoAVela extends Embarcacao {

    public BarcoAVela() {
        super();
        setMovimentationStrategy(new MovimentationVela());
    }

}
