package com.tnicacio.commandstructure.invoker;

import com.tnicacio.commandstructure.command.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InvokerTest {

    private Invoker invoker;
    private Command command;

    @BeforeEach
    void setUp() {
        command = mock(Command.class);
    }

    @Test
    void setCommandShouldSetCommand() {
        invoker = mock(Invoker.class, InvocationOnMock::callRealMethod);

        invoker.setCommand(command);

        verify(invoker).setCommand(command);
    }

    @Test
    void executeShouldCallCommandsExecuteMethod() {
        invoker = new Invoker(command);

        invoker.execute();

        verify(command).execute();
    }

    @Test
    void undoShouldCallCommandsUndoMethod() {
        invoker = new Invoker(command);

        invoker.undo();

        verify(command).undo();
    }

}