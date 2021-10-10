package com.tnicacio.residentialremotecontroller.garagedoor.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.garagedoor.service.GarageDoorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GarageDownCommandTest {

    private Command garageDownCommand;
    private GarageDoorService service;

    @BeforeEach
    void setUp() {
        service = mock(GarageDoorService.class);
        garageDownCommand = new GarageDownCommand(service);
    }

    @Test
    void executeShouldCallGarageServiceDownMethod() {
        garageDownCommand.execute();
        verify(service).down();
    }

    @Test
    void undoShouldCallGarageServiceUpMethod() {
        garageDownCommand.undo();
        verify(service).up();
    }

}