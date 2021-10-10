package com.tnicacio.residentialremotecontroller.command;

public interface Command {

    void execute();
    void undo();

}
