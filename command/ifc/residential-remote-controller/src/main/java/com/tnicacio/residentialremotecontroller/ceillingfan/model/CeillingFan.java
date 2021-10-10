package com.tnicacio.residentialremotecontroller.ceillingfan.model;

public class CeillingFan {

    public enum Speed {HIGH, MEDIUM, LOW, NONE}

    private final String description;
    private Speed speed;
    private boolean on;

    public CeillingFan(String description) {
        this.description = description;
        this.on = false;
        this.speed = Speed.NONE;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public String toString() {
        String desc =  description + " ceilling fan is " ;
        if (!isOn()) {
            return desc + "off";
        }
        return desc + "on with speed " + speed.toString().toLowerCase();
    }
}
