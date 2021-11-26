package com.tnicacio.hometheater.components.player;

import com.tnicacio.hometheater.components.amplifier.Amplifier;

public class DvdPlayer implements Player {

    private Amplifier amplifier;
    private String description;
    private String movie;

    public DvdPlayer(String description) {
        this.description = description;
    }

    @Override
    public void on() {
        System.out.println("Top-O-Line DVD Player on");
    }

    @Override
    public void off() {
        System.out.println("Top-O-Line DVD Player off");
    }

    @Override
    public void eject() {
        System.out.println("Top-O-Line DVD Player eject");
    }

    @Override
    public void pause() {
        System.out.println("Top-O-Line DVD Player pausing");
    }

    @Override
    public void stop() {
        System.out.println("Top-O-Line DVD Player stopped " + "\"" + movie +"\"");
    }

    @Override
    public void play(String movie) {
        this.movie = movie;
        System.out.println("Top-O-Line DVD Player playing " + "\"" + movie +"\"");
    }

    public void setSurroundAudio() {
        System.out.println("Top-O-Line DVD Player setting surround audio");
    }

    public void setTwoChannelAudio() {
        System.out.println("Top-O-Line DVD Player setting two channel audio");
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
