package com.tnicacio.residentialremotecontroller.light.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.light.service.LightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LightOnCommandTest {

    private Command lightOnCommand;
    private LightService service;

    @BeforeEach
    void setUp() {
        service = mock(LightService.class);
        lightOnCommand = new LightOnCommand(service);
    }

    @Test
    void executeShouldCallLightServiceOnMethod() {
        lightOnCommand.execute();
        verify(service).on();
    }

    @Test
    void undoShouldCallLightServiceOffMethod() {
        lightOnCommand.undo();
        verify(service).off();
    }

}