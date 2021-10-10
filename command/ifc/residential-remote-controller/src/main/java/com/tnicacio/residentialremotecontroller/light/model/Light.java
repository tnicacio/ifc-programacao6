package com.tnicacio.residentialremotecontroller.light.model;

public class Light {

    private final String description;
    private boolean on;

    public Light(String description) {
        this.description = description;
        this.on = false;
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

    @Override
    public String toString() {
        return description + " light is " + (isOn() ? "on" : "off");
    }

}
