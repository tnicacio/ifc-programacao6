package com.tnicacio.rentaboat.entities.enums;

public enum TipoMovimentacao {

    MOTOR("Motor"),
    REMOS("Remos"),
    VELA("Vela");

    private String tipoMovimentacao;

    TipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

}
