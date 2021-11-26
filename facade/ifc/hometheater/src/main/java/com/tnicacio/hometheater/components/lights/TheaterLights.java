package com.tnicacio.hometheater.components.lights;

public class TheaterLights {

    public void on() {
        System.out.println("Theater Ceiling Lights on");
    }

    public void off() {
        System.out.println("Theater Ceiling Lights off");
    }

    public void dim(int percentageToDim) {
        System.out.println("Theater Ceiling Lights dimming to " + (100 - percentageToDim) + "%");
    }

}
