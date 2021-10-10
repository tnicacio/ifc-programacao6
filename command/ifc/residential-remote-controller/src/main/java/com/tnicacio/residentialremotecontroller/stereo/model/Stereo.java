package com.tnicacio.residentialremotecontroller.stereo.model;

public class Stereo {

    private final String description;
    private boolean on;
    private boolean CD;
    private boolean DVD;
    private boolean radio;
    private int volume;

    public Stereo(String description) {
        this.description = description;
        this.on = false;
        this.CD = false;
        this.DVD = false;
        this.radio = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isCD() {
        return CD;
    }

    public void setCD(boolean CD) {
        this.CD = CD;
    }

    public boolean isDVD() {
        return DVD;
    }

    public void setDVD(boolean DVD) {
        this.DVD = DVD;
    }

    public boolean isRadio() {
        return radio;
    }

    public void setRadio(boolean radio) {
        this.radio = radio;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        String desc = description + " stereo is";
        if (!isOn()) {
            return desc + " off";
        }

        desc += " on";

        if (isCD()) {
            desc += " with CD";
        }
        if (isDVD()) {
            desc += " with DVD";
        }
        if (isRadio()) {
            desc += " with radio";
        }
        if (volume > 0) {
            desc += " with volume " + volume;
        }
        return desc;
    }

}
