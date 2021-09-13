package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.enums.DuckConstants;
import com.tnicacio.ducktales.enums.FlyBehaviorConstants;
import com.tnicacio.ducktales.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MallardDuckTest {

    private MallardDuck mallardDuck;

    @Nested
    public class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            mallardDuck = new MallardDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldLookLikeAMallard() {
            mallardDuck.display();
            Assertions.assertEquals(DuckConstants.LOOKS_LIKE_A_MALLARD.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformFly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            mallardDuck = new MallardDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldFlyWithWings() {
            mallardDuck.performFly();
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
            mallardDuck = new MallardDuck();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldQuack() {
            mallardDuck.performQuack();
            Assertions.assertEquals(QuackBehaviorConstants.QUACK.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
