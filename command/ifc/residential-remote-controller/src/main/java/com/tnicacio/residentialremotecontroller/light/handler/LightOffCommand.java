package com.tnicacio.residentialremotecontroller.light.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.light.service.LightService;

public class LightOffCommand implements Command {

    private final LightService lightService;

    public LightOffCommand(LightService lightService) {
        this.lightService = lightService;
    }

    @Override
    public void execute() {
        lightService.off();
    }

    @Override
    public void undo() {
        lightService.on();
    }

    @Override
    public String toString() {
        return lightService.toString();
    }

}
