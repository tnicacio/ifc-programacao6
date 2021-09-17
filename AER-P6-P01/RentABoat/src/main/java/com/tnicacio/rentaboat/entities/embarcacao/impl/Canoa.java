package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao.MovimentacaoARemos;

public class Canoa extends Embarcacao {

    public Canoa() {
        super();
        setEstrategiaMovimentacao(new MovimentacaoARemos());
    }

}
