package com.tnicacio.ducktales.entities.enums;

public enum QuackBehaviorConstants {

    QUACK("implements duck quacking"),
    SQUEAK("rubber duckie squeak"),
    MUTE_QUACK("do nothing - can't quack!");

    private final String text;

    QuackBehaviorConstants(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
