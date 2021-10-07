package com.tnicacio.commandstructure.invoker;

import com.tnicacio.commandstructure.comand.Command;

/**
 * The Invoker holds a command and at some point asks the command
 * to carry out a request by calling its execute() method.
 */
public class Invoker {

    private Command command;

    @Deprecated
    public Invoker() {}

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
