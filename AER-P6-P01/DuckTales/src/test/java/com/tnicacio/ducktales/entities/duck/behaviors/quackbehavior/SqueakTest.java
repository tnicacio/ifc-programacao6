package com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior;

import com.tnicacio.ducktales.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SqueakTest {

    @Nested
    class Quack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private Squeak squeak;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            squeak = new Squeak();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldSqueak() {
            squeak.quack();
            Assertions.assertEquals(QuackBehaviorConstants.SQUEAK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
