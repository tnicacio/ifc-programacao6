package com.tnicacio.ducktales.entities.enums;

public enum DuckConstants {

    SPLASH("splash!"),
    LOOKS_LIKE_A_MALLARD("looks like a mallard"),
    LOOKS_LIKE_A_REDHEAD("looks like a redhead"),
    LOOKS_LIKE_A_RUBBERDUCK("looks like a rubberduck"),
    LOOKS_LIKE_A_DECOY("looks like a decoy");

    private final String text;

    DuckConstants(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
