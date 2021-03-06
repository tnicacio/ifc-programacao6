package com.tnicacio.commandstructure.invoker;

import com.tnicacio.commandstructure.command.Command;

/**
 * The Invoker holds a command and at some point asks the command
 * to carry out a request by calling its execute() method.
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    public void undo() {
        command.undo();
    }

}
