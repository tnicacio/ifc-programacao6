package com.tnicacio.ducktales.enums;

public enum FlyBehaviorConstants {

    FLY_NO_WAY("do nothing - can't fly!"),
    FLY_WITH_WINGS("implements duck flying");

    private final String text;

    FlyBehaviorConstants(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
