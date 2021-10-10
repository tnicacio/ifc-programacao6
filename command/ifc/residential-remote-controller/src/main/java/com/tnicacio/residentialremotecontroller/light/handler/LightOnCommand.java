package com.tnicacio.residentialremotecontroller.light.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.light.service.LightService;

public class LightOnCommand implements Command {

    private final LightService lightService;

    public LightOnCommand(LightService lightService) {
        this.lightService = lightService;
    }

    @Override
    public void execute() {
        lightService.on();
    }

    @Override
    public void undo() {
        lightService.off();
    }

    @Override
    public String toString() {
        return lightService.toString();
    }
}
