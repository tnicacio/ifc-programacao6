package com.tnicacio.residentialremotecontroller.light.service;

import com.tnicacio.residentialremotecontroller.light.model.Light;

public class LightService {

    private Light light;

    public LightService(Light light) {
        this.light = light;
    }

    public void on() {
        light.setOn(true);
    }

    public void off() {
        light.setOn(false);
    }

    @Override
    public String toString() {
        return light.toString();
    }

}
