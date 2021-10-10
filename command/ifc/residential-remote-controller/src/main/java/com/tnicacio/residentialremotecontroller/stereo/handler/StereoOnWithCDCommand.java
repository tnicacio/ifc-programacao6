package com.tnicacio.residentialremotecontroller.stereo.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.stereo.service.StereoService;

public class StereoOnWithCDCommand implements Command {

    private final StereoService stereoService;

    public StereoOnWithCDCommand(StereoService stereoService) {
        this.stereoService = stereoService;
    }

    @Override
    public void execute() {
        stereoService.onWithCD();
    }

    @Override
    public void undo() {
        stereoService.off();
    }

    @Override
    public String toString() {
        return stereoService.toString();
    }
    
}
