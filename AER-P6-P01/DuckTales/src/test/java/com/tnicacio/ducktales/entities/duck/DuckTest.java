package com.tnicacio.ducktales.entities.duck;

import com.tnicacio.ducktales.entities.duck.behaviors.flybehavior.FlyBehavior;
import com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior.QuackBehavior;
import com.tnicacio.ducktales.enums.DuckConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DuckTest {

    private static final String LOOKS_LIKE_A_DUMMY_DUCK = "looks like a dummy duck";
    private static final String DUMMY_FLY = "dummy fly";
    private static final String DUMMY_QUACK = "dummy quack";

    private DuckImplDefaultTest duckImplDefaultTest;
    private FlyBehaviorDefaultTest flyBehaviorDefaultTest;
    private QuackBehaviorDefaultTest quackBehaviorDefaultTest;

    @Nested
    public class Swim {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            duckImplDefaultTest = new DuckImplDefaultTest();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldPrintSplash() {
            duckImplDefaultTest.swim();
            Assertions.assertEquals(DuckConstants.SPLASH.toString(), outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class Display {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            duckImplDefaultTest = new DuckImplDefaultTest();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldLookLikeADummyDuck() {
            duckImplDefaultTest.display();
            Assertions.assertEquals(LOOKS_LIKE_A_DUMMY_DUCK, outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformFly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            duckImplDefaultTest = new DuckImplDefaultTest();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldDummyFly() {
            duckImplDefaultTest.performFly();
            Assertions.assertEquals(DUMMY_FLY, outputStreamCaptor.toString().trim());
        }
    }

    @Nested
    public class PerformQuack {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            duckImplDefaultTest = new DuckImplDefaultTest();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldDummyQuack() {
            duckImplDefaultTest.performQuack();
            Assertions.assertEquals(DUMMY_QUACK, outputStreamCaptor.toString().trim());
        }
    }

    private static class DuckImplDefaultTest extends Duck {

        DuckImplDefaultTest() {
            setQuackBehavior(new QuackBehaviorDefaultTest());
            setFlyBehavior(new FlyBehaviorDefaultTest());
        }

        @Override
        public void display() {
            System.out.println(LOOKS_LIKE_A_DUMMY_DUCK);
        }
    }

    private static class FlyBehaviorDefaultTest implements FlyBehavior {

        @Override
        public void fly() {
            System.out.println(DUMMY_FLY);
        }
    }

    private static class QuackBehaviorDefaultTest implements QuackBehavior {

        @Override
        public void quack() {
            System.out.println(DUMMY_QUACK);
        }
    }

}
