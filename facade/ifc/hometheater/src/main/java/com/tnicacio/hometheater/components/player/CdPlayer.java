package com.tnicacio.hometheater.components.player;

import com.tnicacio.hometheater.components.amplifier.Amplifier;

public class CdPlayer implements Player {

    private Amplifier amplifier;
    private String description;

    public CdPlayer(String description) {
        this.description = description;
    }

    @Override
    public void on() {
        System.out.println("Top-O-Line CD Player on");
    }

    @Override
    public void off() {
        System.out.println("Top-O-Line CD Player off");
    }

    @Override
    public void eject() {
        System.out.println("Top-O-Line CD Player eject");
    }

    @Override
    public void pause() {
        System.out.println("Top-O-Line CD Player pausing");
    }

    @Override
    public void play(String movie) {
        System.out.println("Top-O-Line CD Player playing " + "\"" + movie + "\"");
    }

    @Override
    public void stop() {
        System.out.println("Top-O-Line CD Player stopping");
    }

    public Amplifier getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

    @Override
    public String toString() {
        return description;
    }

}
