package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.enums.DuckConstants;
import com.tnicacio.ducktales.services.duckbehaviors.flybehavior.FlyWithWings;
import com.tnicacio.ducktales.services.duckbehaviors.quackbehavior.Quack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class MallardDuckTest {

    @Nested
    class Constructor {

        @Test
        void shouldSetFlyBehaviorAsFlyWithWings() {
            Duck mallardDuck = new MallardDuck();
            assertSame(new FlyWithWings().getClass(), mallardDuck.getFlyBehavior().getClass());
        }

        @Test
        void shouldSetQuackBehaviorAsQuack() {
            Duck mallardDuck = new MallardDuck();
            assertSame(new Quack().getClass(), mallardDuck.getQuackBehavior().getClass());
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
        void shouldLookLikeADecoy() {
            Duck mallardDuck = new MallardDuck();
            mallardDuck.display();
            assertEquals(DuckConstants.LOOKS_LIKE_A_MALLARD.toString(), outputStreamCaptor.toString().trim());
        }

    }

}
