package com.tnicacio.residentialremotecontroller.garagedoor.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.garagedoor.service.GarageDoorService;

public class GarageDownCommand implements Command {

    private final GarageDoorService garageDoorService;

    public GarageDownCommand(GarageDoorService garageDoorService) {
        this.garageDoorService = garageDoorService;
    }

    @Override
    public void execute() {
        garageDoorService.down();
    }

    @Override
    public void undo() {
        garageDoorService.up();
    }

    @Override
    public String toString() {
        return garageDoorService.toString();
    }

}
