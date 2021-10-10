package com.tnicacio.ducktales.duck;

import com.tnicacio.ducktales.enums.DuckConstants;
import com.tnicacio.ducktales.behaviors.flybehavior.FlyBehavior;
import com.tnicacio.ducktales.behaviors.quackbehavior.QuackBehavior;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DuckTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    private DuckImplDefaultTest duckImplDefaultTest;
    private Duck duck;

    private static class DuckImplDefaultTest extends Duck {

        DuckImplDefaultTest() {
        }

        @Override
        public void display() {
        }

    }

    @Nested
    class Swim {

        @BeforeEach
        void setUp() {
            standardOut = System.out;
            outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
            duckImplDefaultTest = new DuckImplDefaultTest();
        }

        @AfterEach
        void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldPrintSplash() {
            duckImplDefaultTest.swim();
            assertEquals(DuckConstants.SPLASH.toString(), outputStreamCaptor.toString().trim());
        }

        @Test
        void shouldSwim() {
            duck = Mockito.mock(Duck.class);
            duck.swim();
            verify(duck).swim();
        }
    }

    @Nested
    class Display {

        @Test
        void shouldDisplay() {
            duck = Mockito.mock(Duck.class);
            duck.display();
            verify(duck, only()).display();
        }
    }

    @Nested
    class PerformFly {

        @Test
        void shouldPerformFly() {
            duck = Mockito.mock(Duck.class);
            duck.performFly();
            verify(duck, only()).performFly();
        }

        @Test
        void shouldCallFlyBehaviorFly() {
            FlyBehavior flyBehavior = mock(FlyBehavior.class);
            duck = Mockito.spy(Duck.class);
            duck.setFlyBehavior(flyBehavior);

            duck.performFly();

            verify(duck, times(1)).performFly();
            verify(flyBehavior, only()).fly();
        }

    }

    @Nested
    class PerformQuack {

        @Test
        void shouldPerformQuack() {
            duck = Mockito.mock(Duck.class);
            duck.performQuack();
            verify(duck, only()).performQuack();
        }

        @Test
        void shouldCallQuackBehaviorQuack() {
            QuackBehavior quackBehavior = mock(QuackBehavior.class);
            duck = Mockito.spy(Duck.class);
            duck.setQuackBehavior(quackBehavior);

            duck.performQuack();

            verify(duck, times(1)).performQuack();
            verify(quackBehavior, only()).quack();
        }
    }

}
