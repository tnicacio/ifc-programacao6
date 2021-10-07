package com.tnicacio.commandstructure.comand;

/**
 * Command declares an interface for all commands. As you already know, a
 * command is invoked through its execute() method, wich asks a receiver to
 * perform an action. You'll also notice this interface has an undo() method.
 */
public interface Command {

    void execute();
    void undo();

}
