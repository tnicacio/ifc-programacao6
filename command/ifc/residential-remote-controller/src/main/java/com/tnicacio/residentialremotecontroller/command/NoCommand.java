package com.tnicacio.residentialremotecontroller.command;

public class NoCommand implements Command {

    @Override
    public void execute() {
        //Do nothing
    }

    @Override
    public void undo() {
        //Do nothing
    }

    @Override
    public String toString() {
        return "No command";
    }

}
