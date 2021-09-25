package com.tnicacio.ducktales.duck.impl;

import com.tnicacio.ducktales.duck.Duck;
import com.tnicacio.ducktales.enums.DuckConstants;
import com.tnicacio.ducktales.behaviors.flybehavior.FlyWithWings;
import com.tnicacio.ducktales.behaviors.quackbehavior.Quack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RedheadDuckTest {

    @Nested
    class Constructor {

        @Test
        void shouldSetFlyBehaviorAsFlyWithWings() {
            Duck redheadDuck = new RedheadDuck();
            assertSame(new FlyWithWings().getClass(), redheadDuck.getFlyBehavior().getClass());
        }

        @Test
        void shouldSetQuackBehaviorAsQuack() {
            Duck redheadDuck = new RedheadDuck();
            assertSame(new Quack().getClass(), redheadDuck.getQuackBehavior().getClass());
        }

    }

    @Nested
    class Display {

        private ByteArrayOutputStream outputStreamCaptor;

        @BeforeEach
        void setUp() {
            outputStreamCaptor = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @AfterEach
        void tearDown() {
            System.setOut(System.out);
        }

        @Test
        void shouldPrintLooksLikeARedheadDuck() {
            Duck redheadDuck = new RedheadDuck();
            redheadDuck.display();
            assertEquals(DuckConstants.LOOKS_LIKE_A_REDHEAD.toString(), outputStreamCaptor.toString().trim());
        }

    }

}
