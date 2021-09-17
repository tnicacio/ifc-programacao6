package com.tnicacio.rentaboat.entities.embarcacao;

import com.tnicacio.rentaboat.entities.enums.TipoMovimentacao;
import com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao.EstrategiaMovimentacao;

public abstract class Embarcacao {

    EstrategiaMovimentacao estrategiaMovimentacao;

    public void setEstrategiaMovimentacao(EstrategiaMovimentacao estrategiaMovimentacao) {
        this.estrategiaMovimentacao = estrategiaMovimentacao;
    }

    public TipoMovimentacao getModoDeMovimentacao() {
        return estrategiaMovimentacao.modoMovimentacao();
    }

}
