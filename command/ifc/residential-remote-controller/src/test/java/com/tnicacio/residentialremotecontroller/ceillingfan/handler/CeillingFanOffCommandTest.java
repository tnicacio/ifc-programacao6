package com.tnicacio.residentialremotecontroller.ceillingfan.handler;

import com.tnicacio.residentialremotecontroller.ceillingfan.service.CeillingFanService;
import com.tnicacio.residentialremotecontroller.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CeillingFanOffCommandTest {

    private Command ceillingFanOffCommand;
    private CeillingFanService service;

    @BeforeEach
    void setUp() {
        service = mock(CeillingFanService.class);
        ceillingFanOffCommand = new CeillingFanOffCommand(service);
    }

    @Test
    void executeShouldCallCeillingFanServiceOffMethod() {
        ceillingFanOffCommand.execute();
        verify(service).off();
    }

    @Test
    void undoShouldCallCeillingFanServiceHighSpeedMethod() {
        ceillingFanOffCommand.undo();
        verify(service).highSpeed();
    }

}
