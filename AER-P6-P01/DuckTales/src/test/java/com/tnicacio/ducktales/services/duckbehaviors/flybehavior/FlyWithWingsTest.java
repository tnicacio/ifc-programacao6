package com.tnicacio.ducktales.services.duckbehaviors.flybehavior;

import com.tnicacio.ducktales.entities.enums.FlyBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class FlyWithWingsTest {

    @Nested
    class Fly {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private FlyWithWings flyWithWings;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            flyWithWings = new FlyWithWings();
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        void shouldFlyWithWings() {
            flyWithWings.fly();
            Assertions.assertEquals(FlyBehaviorConstants.FLY_WITH_WINGS.toString(), outputStreamCaptor.toString().trim());
        }
    }

}
