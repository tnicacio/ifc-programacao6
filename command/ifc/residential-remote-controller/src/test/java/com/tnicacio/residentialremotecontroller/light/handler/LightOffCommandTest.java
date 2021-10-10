package com.tnicacio.residentialremotecontroller.light.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.light.service.LightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class LightOffCommandTest {

    private Command lightOffCommand;
    private LightService service;

    @BeforeEach
    void setUp() {
        service = mock(LightService.class);
        lightOffCommand = new LightOffCommand(service);
    }

    @Test
    void executeShouldCallLightServiceOffMethod() {
        lightOffCommand.execute();
        verify(service).off();
    }

    @Test
    void undoShouldCallLightServiceOnfMethod() {
        lightOffCommand.undo();
        verify(service).on();
    }

}