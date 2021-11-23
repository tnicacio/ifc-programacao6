package com.tnicacio.audioplayer.audioformat;

public class Mp3Player implements AudioFormat {

    private String name;

    @Override
    public void open(String name) {
        this.name = name;
        System.out.println("Opening " + name + ".mp3");
    }

    @Override
    public void reproduce() {
        System.out.println("Reproducing " + name);
    }

    @Override
    public void stop() {
        System.out.println("Stopping " + name);
    }

}
