package com.tnicacio.commandstructure;

import com.tnicacio.commandstructure.comand.Command;
import com.tnicacio.commandstructure.comand.ConcreteCommand;
import com.tnicacio.commandstructure.invoker.Invoker;
import com.tnicacio.commandstructure.receiver.Receiver;

/**
 * The Client is responsible for creating a ConcreteCommand
 * and setting its Receiver.
 */
public class Client {

    public static void main(String... args) {

        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker(command);

        command.execute();
        command.undo();
    }

}
