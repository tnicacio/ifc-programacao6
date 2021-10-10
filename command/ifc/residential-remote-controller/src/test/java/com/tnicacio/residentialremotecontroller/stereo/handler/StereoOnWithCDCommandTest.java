package com.tnicacio.residentialremotecontroller.stereo.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.stereo.service.StereoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StereoOnWithCDCommandTest {

    private Command stereoOnWithCDCommand;
    private StereoService stereoService;

    @BeforeEach
    void setUp() {
        stereoService = mock(StereoService.class);
        stereoOnWithCDCommand = new StereoOnWithCDCommand(stereoService);
    }

    @Test
    void executeShouldCallStereoServiceOnWithCDMethod() {
        stereoOnWithCDCommand.execute();
        verify(stereoService).onWithCD();
    }

    @Test
    void undoShouldCallStereoServiceOffMethod() {
        stereoOnWithCDCommand.undo();
        verify(stereoService).off();
    }

}
