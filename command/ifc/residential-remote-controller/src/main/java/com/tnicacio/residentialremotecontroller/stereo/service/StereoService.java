package com.tnicacio.residentialremotecontroller.stereo.service;

import com.tnicacio.residentialremotecontroller.stereo.model.Stereo;

public class StereoService {

    private Stereo stereo;

    public StereoService(Stereo stereo) {
        this.stereo = stereo;
    }

    public void on() {
        stereo.setOn(true);
    }

    public void off() {
        stereo.setVolume(0);
        stereo.setCD(false);
        stereo.setDVD(false);
        stereo.setRadio(false);
        stereo.setOn(false);
    }

    public void onWithCD() {
        stereo.setOn(true);
        stereo.setCD(true);
        stereo.setVolume(11);
    }

    @Override
    public String toString() {
        return stereo.toString();
    }

}
