package com.tnicacio.residentialremotecontroller.ceillingfan.service;

import com.tnicacio.residentialremotecontroller.ceillingfan.model.CeillingFan;

public class CeillingFanService {

    private CeillingFan ceillingFan;

    public CeillingFanService(CeillingFan ceillingFan) {
        this.ceillingFan = ceillingFan;
    }

    public void highSpeed() {
        ceillingFan.setOn(true);
        ceillingFan.setSpeed(CeillingFan.Speed.HIGH);
    }

    public void mediumSpeed() {
        ceillingFan.setOn(true);
        ceillingFan.setSpeed(CeillingFan.Speed.MEDIUM);
    }

    public void lowSpeed() {
        ceillingFan.setOn(true);
        ceillingFan.setSpeed(CeillingFan.Speed.LOW);
    }

    public void off() {
        ceillingFan.setSpeed(CeillingFan.Speed.NONE);
        ceillingFan.setOn(false);
    }

    @Override
    public String toString() {
        return ceillingFan.toString();
    }

}
