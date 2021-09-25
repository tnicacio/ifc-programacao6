package com.tnicacio.ducktales.behaviors.flybehavior;

import com.tnicacio.ducktales.enums.FlyBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FlyNoWayTest {

    @Nested
    class Fly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private FlyNoWay flyNoWay;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            flyNoWay = new FlyNoWay();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldFlyNoWay() {
            flyNoWay.fly();
            Assertions.assertEquals(FlyBehaviorConstants.FLY_NO_WAY.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
