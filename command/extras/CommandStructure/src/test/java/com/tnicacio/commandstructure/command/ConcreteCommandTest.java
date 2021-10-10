package com.tnicacio.commandstructure.command;

import com.tnicacio.commandstructure.receiver.Receiver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ConcreteCommandTest {

    private Command command;
    private Receiver receiver;

    @BeforeEach
    void setUp() {
        receiver = mock(Receiver.class);
        command = new ConcreteCommand(receiver);
    }

    @Test
    void executeShouldInvokeLinkedReceiverAction() {
        command.execute();
        verify(receiver).action();
    }

    @Test
    void undoShouldInvokeLinkedReceiverUndoAction() {
        command.undo();
        verify(receiver).undoAction();
    }

}