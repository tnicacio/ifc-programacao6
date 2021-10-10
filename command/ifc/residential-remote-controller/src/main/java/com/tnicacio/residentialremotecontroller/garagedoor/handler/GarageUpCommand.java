package com.tnicacio.residentialremotecontroller.garagedoor.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.garagedoor.service.GarageDoorService;

public class GarageUpCommand implements Command {

    private final GarageDoorService garageDoorService;

    public GarageUpCommand(GarageDoorService garageDoorService) {
        this.garageDoorService = garageDoorService;
    }

    @Override
    public void execute() {
        garageDoorService.up();
    }

    @Override
    public void undo() {
        garageDoorService.down();
    }

    @Override
    public String toString() {
        return garageDoorService.toString();
    }

}
