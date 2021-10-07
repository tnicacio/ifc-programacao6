package com.tnicacio.commandstructure.comand;

import com.tnicacio.commandstructure.receiver.Receiver;

/**
 * The ConcreteCommand defines a binding between an action and a Receiver.
 * The invoker makes a request by calling execute() and the ConcreteCommand
 * carries it out by calling one or more actions on the Receiver.
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * The execute method invokes the action(s) on the receiver
     * needed to fulfill the request
     */
    @Override
    public void execute() {
        receiver.action();
    }

    @Override
    public void undo() {
        receiver.undoAction();
    }

}
