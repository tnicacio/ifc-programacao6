package com.tnicacio.residentialremotecontroller.ceillingfan.handler;

import com.tnicacio.residentialremotecontroller.ceillingfan.service.CeillingFanService;
import com.tnicacio.residentialremotecontroller.command.Command;

public class CeillingFanHighCommand implements Command {

    private CeillingFanService ceillingFanService;

    public CeillingFanHighCommand(CeillingFanService ceillingFanService) {
        this.ceillingFanService = ceillingFanService;
    }

    @Override
    public void execute() {
        ceillingFanService.highSpeed();
    }

    @Override
    public void undo() {
        ceillingFanService.off();
    }

    @Override
    public String toString() {
        return ceillingFanService.toString();
    }

}
