package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.enums.DuckConstants;
import com.tnicacio.ducktales.entities.enums.FlyBehaviorConstants;
import com.tnicacio.ducktales.entities.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RubberDuckTest {

    private RubberDuck rubberDuck;

    @Nested
    public class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            rubberDuck = new RubberDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldLookLikeARubberduck() {
            rubberDuck.display();
            Assertions.assertEquals(DuckConstants.LOOKS_LIKE_A_RUBBERDUCK.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformFly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            rubberDuck = new RubberDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldFlyNoWay() {
            rubberDuck.performFly();
            Assertions.assertEquals(FlyBehaviorConstants.FLY_NO_WAY.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformQuack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            rubberDuck = new RubberDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldSqueak() {
            rubberDuck.performQuack();
            Assertions.assertEquals(QuackBehaviorConstants.SQUEAK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
