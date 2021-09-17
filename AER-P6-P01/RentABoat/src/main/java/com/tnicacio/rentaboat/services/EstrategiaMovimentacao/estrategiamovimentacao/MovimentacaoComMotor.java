package com.tnicacio.rentaboat.services.EstrategiaMovimentacao.estrategiamovimentacao;

import com.tnicacio.rentaboat.entities.enums.TipoMovimentacao;

public class MovimentacaoComMotor implements EstrategiaMovimentacao {

    @Override
    public TipoMovimentacao modoMovimentacao() {
        return TipoMovimentacao.MOTOR;
    }

}
