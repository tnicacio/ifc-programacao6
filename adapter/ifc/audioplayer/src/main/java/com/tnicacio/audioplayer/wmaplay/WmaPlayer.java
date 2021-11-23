package com.tnicacio.audioplayer.wmaplay;

public class WmaPlayer implements WmaPlay {

    private String name;

    @Override
    public void setFile(String name) {
        this.name = name;
            System.out.println("Setting file " + name);
    }

    @Override
    public void open() {
        System.out.println("Opening " + name);
    }

    @Override
    public void setLocation(int seconds) {
        System.out.println("Setting " + name + " on " + seconds + " seconds.");
    }

    @Override
    public void play() {
        System.out.println("Playing " + name);
    }

    @Override
    public void stop() {
        System.out.println("Stopping " + name);
    }

}
