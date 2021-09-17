package com.tnicacio.rentaboat.entities.embarcacao.impl;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao.MovimentacaoAVela;

public class BarcoAVela extends Embarcacao {

    public BarcoAVela() {
        super();
        setEstrategiaMovimentacao(new MovimentacaoAVela());
    }

}
