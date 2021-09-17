package com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao;

import com.tnicacio.rentaboat.entities.enums.TipoMovimentacao;

public class MovimentacaoARemos implements EstrategiaMovimentacao {

    @Override
    public TipoMovimentacao modoMovimentacao() {
        return TipoMovimentacao.REMOS;
    }

}
