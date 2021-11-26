package com.tnicacio.hometheater.components.projector;

import com.tnicacio.hometheater.components.player.DvdPlayer;

public class Projector {

    private DvdPlayer dvdPlayer;

    public void on() {
        System.out.println("Top-O-Line Projector on");
    }

    public void off() {
        System.out.println("Top-O-Line Projector off");
    }

    public void tvMode() {
        System.out.println("Top-O-Line ");
    }

    public void wideScreenMode() {
        System.out.println("Top-O-Line Projector in widescreen mode (16x9 aspect ratio)");
    }

    public void setInput(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public DvdPlayer getDvdPlayer() {
        return dvdPlayer;
    }

    public void setDvdPlayer(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

}
