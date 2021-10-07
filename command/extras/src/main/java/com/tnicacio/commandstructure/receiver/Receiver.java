package com.tnicacio.commandstructure.receiver;

/**
 * The receiver knows how to perform the work needed to
 * carry out the request. Any class can act as a Receiver.
 */
public class Receiver {

    public void action() {
        System.out.println("Performing action");
    }

    public void undoAction() {
        System.out.println("Undoing action");
    }

}
