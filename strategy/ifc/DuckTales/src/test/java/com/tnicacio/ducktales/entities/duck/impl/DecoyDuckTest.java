package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.enums.DuckConstants;
import com.tnicacio.ducktales.services.duckbehaviors.flybehavior.FlyNoWay;
import com.tnicacio.ducktales.services.duckbehaviors.quackbehavior.MuteQuack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class DecoyDuckTest {

    @Nested
    class Constructor {

        @Test
        void shouldSetFlyBehaviorAsFlyNoWay() {
            Duck decoyDuck = new DecoyDuck();
            assertSame(new FlyNoWay().getClass(), decoyDuck.getFlyBehavior().getClass());
        }

        @Test
        void shouldSetQuackBehaviorAsMuteQuack() {
            Duck decoyDuck = new DecoyDuck();
            assertSame(new MuteQuack().getClass(), decoyDuck.getQuackBehavior().getClass());
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
            Duck decoyDuck = new DecoyDuck();
            decoyDuck.display();
            assertEquals(DuckConstants.LOOKS_LIKE_A_DECOY.toString(), outputStreamCaptor.toString().trim());
        }

    }

}
