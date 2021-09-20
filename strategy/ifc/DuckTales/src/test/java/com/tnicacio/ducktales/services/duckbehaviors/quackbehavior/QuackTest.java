package com.tnicacio.ducktales.services.duckbehaviors.quackbehavior;

import com.tnicacio.ducktales.entities.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class QuackTest {

    @Nested
    class DoQuack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private Quack quack;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            quack = new Quack();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldQuack() {
            quack.quack();
            Assertions.assertEquals(QuackBehaviorConstants.QUACK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
