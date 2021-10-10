package com.tnicacio.commandstructure.receiver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ReceiverTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private Receiver receiver;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        receiver = new Receiver();
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void actionShouldPerformAction() {
        receiver.action();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Performing action");
    }

    @Test
    void undoActionShouldUndoAction() {
        receiver.undoAction();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Undoing action");
    }

}