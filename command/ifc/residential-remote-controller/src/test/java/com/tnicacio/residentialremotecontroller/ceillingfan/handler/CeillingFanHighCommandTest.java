package com.tnicacio.residentialremotecontroller.ceillingfan.handler;

import com.tnicacio.residentialremotecontroller.ceillingfan.service.CeillingFanService;
import com.tnicacio.residentialremotecontroller.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CeillingFanHighCommandTest {

    private Command ceillingFanHighCommand;
    private CeillingFanService service;

    @BeforeEach
    void setUp() {
        service = mock(CeillingFanService.class);
        ceillingFanHighCommand = new CeillingFanHighCommand(service);
    }

    @Test
    void executeShouldCallCeillingFanServiceHighSpeedMethod() {
        ceillingFanHighCommand.execute();
        verify(service).highSpeed();
    }

    @Test
    void undoShouldCallCeillingFanServiceOffMethod() {
        ceillingFanHighCommand.undo();
        verify(service).off();
    }

}
