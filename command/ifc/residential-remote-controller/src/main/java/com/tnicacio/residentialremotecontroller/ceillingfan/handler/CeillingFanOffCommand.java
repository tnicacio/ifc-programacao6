package com.tnicacio.residentialremotecontroller.ceillingfan.handler;

import com.tnicacio.residentialremotecontroller.ceillingfan.service.CeillingFanService;
import com.tnicacio.residentialremotecontroller.command.Command;

public class CeillingFanOffCommand implements Command {

    private CeillingFanService ceillingFanService;

    public CeillingFanOffCommand(CeillingFanService ceillingFanService) {
        this.ceillingFanService = ceillingFanService;
    }

    @Override
    public void execute() {
        ceillingFanService.off();
    }

    @Override
    public void undo() {
        ceillingFanService.highSpeed();
    }

    @Override
    public String toString() {
        return ceillingFanService.toString();
    }

}
