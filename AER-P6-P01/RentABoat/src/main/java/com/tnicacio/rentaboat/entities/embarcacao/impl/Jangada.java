package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao.MovimentacaoARemos;

public class Jangada extends Embarcacao {

    public Jangada() {
        super();
        setEstrategiaMovimentacao(new MovimentacaoARemos());
    }

}
