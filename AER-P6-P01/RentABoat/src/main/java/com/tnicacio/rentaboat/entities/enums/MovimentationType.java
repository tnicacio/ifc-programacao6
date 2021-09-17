package com.tnicacio.rentaboat.entities.enums;

public enum MovimentationType {

    MOTOR("Motor"),
    REMOS("Remos"),
    VELA("Vela");

    private String movimentationType;

    MovimentationType(String movimentationType) {
        this.movimentationType = movimentationType;
    }

    public String getValue() {
        return movimentationType;
    }

}
