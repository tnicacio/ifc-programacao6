package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.enums.DuckConstants;
import com.tnicacio.ducktales.enums.FlyBehaviorConstants;
import com.tnicacio.ducktales.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RedheadDuckTest {

    private RedheadDuck redheadDuck;

    @Nested
    public class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            redheadDuck = new RedheadDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldLookLikeARedhead() {
            redheadDuck.display();
            Assertions.assertEquals(DuckConstants.LOOKS_LIKE_A_REDHEAD.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformFly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            redheadDuck = new RedheadDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldFlyWithWings() {
            redheadDuck.performFly();
            Assertions.assertEquals(FlyBehaviorConstants.FLY_WITH_WINGS.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformQuack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            redheadDuck = new RedheadDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldQuack() {
            redheadDuck.performQuack();
            Assertions.assertEquals(QuackBehaviorConstants.QUACK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
