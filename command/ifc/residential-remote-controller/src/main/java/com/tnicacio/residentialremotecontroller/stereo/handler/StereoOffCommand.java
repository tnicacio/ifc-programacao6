package com.tnicacio.residentialremotecontroller.stereo.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.stereo.service.StereoService;

public class StereoOffCommand implements Command {

    private final StereoService stereoService;

    public StereoOffCommand(StereoService stereoService) {
        this.stereoService = stereoService;
    }

    @Override
    public void execute() {
        stereoService.off();
    }

    @Override
    public void undo() {
        stereoService.onWithCD();
    }

    @Override
    public String toString() {
        return stereoService.toString();
    }

}
