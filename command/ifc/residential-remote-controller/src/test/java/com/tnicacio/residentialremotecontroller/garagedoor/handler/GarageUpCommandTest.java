package com.tnicacio.residentialremotecontroller.garagedoor.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.garagedoor.service.GarageDoorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class GarageUpCommandTest {

    private Command garageUpCommand;
    private GarageDoorService service;

    @BeforeEach
    void setUp() {
        service = mock(GarageDoorService.class);
        garageUpCommand = new GarageUpCommand(service);
    }

    @Test
    void executeShouldCallGarageServiceUpMethod() {
        garageUpCommand.execute();
        verify(service).up();
    }

    @Test
    void undoShouldCallGarageServiceDownMethod() {
        garageUpCommand.undo();
        verify(service).down();
    }

}
