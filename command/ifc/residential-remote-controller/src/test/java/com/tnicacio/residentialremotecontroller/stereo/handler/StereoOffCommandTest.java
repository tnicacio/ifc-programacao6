package com.tnicacio.residentialremotecontroller.stereo.handler;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.stereo.service.StereoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class StereoOffCommandTest {

    private Command stereoOffCommand;
    private StereoService stereoService;

    @BeforeEach
    void setUp() {
        stereoService = mock(StereoService.class);
        stereoOffCommand = new StereoOffCommand(stereoService);
    }

    @Test
    void executeShouldCallStereoServiceOffMethod() {
        stereoOffCommand.execute();
        verify(stereoService).off();
    }

    @Test
    void undoShouldCallStereoServiceOnWithCDMethod() {
        stereoOffCommand.undo();
        verify(stereoService).onWithCD();
    }

}
