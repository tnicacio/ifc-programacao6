package com.tnicacio.hometheater.components.tuner;

import com.tnicacio.hometheater.components.amplifier.Amplifier;

public class Tuner {

    private Amplifier amplifier;

    public void on() {
        System.out.println("Tuner on");
    }

    public void off() {
        System.out.println("Tuner off");
    }

    public void setAm() {
        System.out.println("Tuner set Am");
    }

    public void setFm() {
        System.out.println("Tuner set Fm");
    }

    public void setFrequency(int frequency) {
        System.out.println("Tuner setting frequency to " + frequency + "Hz");
    }

    public Amplifier getAmplifier() {
        return amplifier;
    }

    public void setAmplifier(Amplifier amplifier) {
        this.amplifier = amplifier;
    }

}
