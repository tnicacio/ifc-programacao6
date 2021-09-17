package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao.MovimentacaoComMotor;

public class Iate extends Embarcacao {

    public Iate() {
        super();
        setEstrategiaMovimentacao(new MovimentacaoComMotor());
    }

}
