package com.tnicacio.residentialremotecontroller.remotecontrol;

import com.tnicacio.residentialremotecontroller.command.Command;
import com.tnicacio.residentialremotecontroller.command.NoCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoteControl {

    private final Deque<Command> executed = new ArrayDeque<>();
    private final Command noCommand = new NoCommand();
    private Command[] onCommands;
    private Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        executed.push(noCommand);
    }

    public void setCommand(int slot, Command onCommand, Command offComand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offComand;
    }

    public void onButtonPushed(int slot) {
        onCommands[slot].execute();
        System.out.println(onCommands[slot].toString());

        executed.push(onCommands[slot]);
    }

    public void offButtonPushed(int slot) {
        offCommands[slot].execute();
        System.out.println(offCommands[slot].toString());

        executed.push(offCommands[slot]);
    }

    public void undoButtonPushed() {
        executed.getFirst().undo();
        System.out.println(executed.getFirst().toString());

        if (executed.size() > 1 && executed.getFirst() != noCommand) {
            executed.pop();
        }
    }

    @Override
    public String toString() {
        String lineBreak = "\n";
        String tab = "\t";

        StringBuilder sb = new StringBuilder()
                .append("----- Remote Control -----")
                .append(lineBreak);

        for (int i = 0; i < 7; i++) {
            sb.append("[slot " + i + "]")
                    .append(tab)
                    .append(onCommands[i].getClass().getSimpleName())
                    .append(tab)
                    .append(offCommands[i].getClass().getSimpleName())
                    .append(lineBreak);
        }
        return sb.toString();
    }

}
