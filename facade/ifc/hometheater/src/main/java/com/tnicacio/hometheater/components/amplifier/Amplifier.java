package com.tnicacio.hometheater.components.amplifier;

import com.tnicacio.hometheater.components.player.CdPlayer;
import com.tnicacio.hometheater.components.player.DvdPlayer;
import com.tnicacio.hometheater.components.tuner.Tuner;

public class Amplifier {

    private Tuner tuner;
    private DvdPlayer dvdPlayer;
    private CdPlayer cdPlayer;
    private int volume;

    public void on() {
        System.out.println("Top-O-Line Amplifier on");
    }

    public void off() {
        System.out.println("Top-O-Line Amplifier off");
    }

    public void setCd(CdPlayer cdPlayer) {
        this.cdPlayer = cdPlayer;
    }

    public void setDvd(DvdPlayer dvdPlayer) {
        this.dvdPlayer =dvdPlayer;
        System.out.println("Top-O-Line Amplifier setting DVD player to " + dvdPlayer);
    }

    public void setStereoSound() {
        System.out.println("Top-O-Line Amplifier stereo sound on");
    }

    public void setSurroundSound() {
        System.out.println("Top-O-Line Amplifier surround sound on (5 speakers, 1 subwoofer)");
        if (dvdPlayer != null) {
            dvdPlayer.setSurroundAudio();
        }
    }

    public void setTuner(Tuner tuner) {
        this.tuner = tuner;
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("Top-O-Line Amplifier setting volume to " + volume);
    }

    public Tuner getTuner() {
        return tuner;
    }

    public DvdPlayer getDvd() {
        return dvdPlayer;
    }

    public CdPlayer getCd() {
        return cdPlayer;
    }

    public int getVolume() {
        return volume;
    }

}
