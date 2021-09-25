package com.tnicacio.ducktales.behaviors.quackbehavior;

import com.tnicacio.ducktales.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MuteQuackTest {

    @Nested
    class Quack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private MuteQuack muteQuack;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            muteQuack = new MuteQuack();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldNotBeAbleToQuack() {
            muteQuack.quack();
            Assertions.assertEquals(QuackBehaviorConstants.MUTE_QUACK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
