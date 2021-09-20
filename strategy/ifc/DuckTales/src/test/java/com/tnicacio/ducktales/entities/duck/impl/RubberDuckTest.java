package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.enums.DuckConstants;
import com.tnicacio.ducktales.services.duckbehaviors.flybehavior.FlyNoWay;
import com.tnicacio.ducktales.services.duckbehaviors.quackbehavior.Squeak;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RubberDuckTest {

    @Nested
    class Constructor {

        @Test
        void shouldSetFlyBehaviorAsFlyNoWay() {
            Duck rubberDuck = new RubberDuck();
            assertSame(new FlyNoWay().getClass(), rubberDuck.getFlyBehavior().getClass());
        }

        @Test
        void shouldSetQuackBehaviorAsSqueak() {
            Duck rubberDuck = new RubberDuck();
            assertSame(new Squeak().getClass(), rubberDuck.getQuackBehavior().getClass());
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
            Duck rubberDuck = new RubberDuck();
            rubberDuck.display();
            assertEquals(DuckConstants.LOOKS_LIKE_A_RUBBERDUCK.toString(), outputStreamCaptor.toString().trim());
        }

    }

}
