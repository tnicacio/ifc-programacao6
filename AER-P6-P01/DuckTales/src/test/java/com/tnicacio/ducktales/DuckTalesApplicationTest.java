package com.tnicacio.ducktales;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.duck.impl.DecoyDuck;
import com.tnicacio.ducktales.entities.duck.impl.MallardDuck;
import com.tnicacio.ducktales.entities.duck.impl.RedheadDuck;
import com.tnicacio.ducktales.entities.duck.impl.RubberDuck;
import com.tnicacio.ducktales.enums.DuckConstants;
import com.tnicacio.ducktales.enums.FlyBehaviorConstants;
import com.tnicacio.ducktales.enums.QuackBehaviorConstants;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuckTalesApplicationTest {

    private DuckTalesApplication duckTalesApplication;

    @Nested
    public class RunMain {

        private final PrintStream standardOut = System.out;
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        private List<Duck> ducks;

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
            duckTalesApplication = new DuckTalesApplication();
            ducks = List.of(new MallardDuck(),
                    new RedheadDuck(),
                    new RubberDuck(),
                    new DecoyDuck());
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }

        @Test
        public void shouldPrintClassNameDisplaySwimPerformQuackAndFlyInformations() {

            Map<String, String> duckInfoMap = new HashMap<>();
            String lineBreak = "\r\n";
            String dashedLine = "---------";

            String mallardDuckInfo = new StringBuilder()
                    .append(DuckConstants.LOOKS_LIKE_A_MALLARD).append(lineBreak)
                    .append(DuckConstants.SPLASH).append(lineBreak)
                    .append(QuackBehaviorConstants.QUACK).append(lineBreak)
                    .append(FlyBehaviorConstants.FLY_WITH_WINGS).append(lineBreak)
                    .append(dashedLine).append(lineBreak)
                    .toString();
            duckInfoMap.put(getDuckClassSimpleName(new MallardDuck()), mallardDuckInfo);

            String redheadDuckInfo = new StringBuilder()
                    .append(DuckConstants.LOOKS_LIKE_A_REDHEAD).append(lineBreak)
                    .append(DuckConstants.SPLASH).append(lineBreak)
                    .append(QuackBehaviorConstants.QUACK).append(lineBreak)
                    .append(FlyBehaviorConstants.FLY_WITH_WINGS).append(lineBreak)
                    .append(dashedLine).append(lineBreak)
                    .toString();
            duckInfoMap.put(getDuckClassSimpleName(new RedheadDuck()), redheadDuckInfo);

            String rubberDuckInfo = new StringBuilder()
                    .append(DuckConstants.LOOKS_LIKE_A_RUBBERDUCK).append(lineBreak)
                    .append(DuckConstants.SPLASH).append(lineBreak)
                    .append(QuackBehaviorConstants.SQUEAK).append(lineBreak)
                    .append(FlyBehaviorConstants.FLY_NO_WAY).append(lineBreak)
                    .append(dashedLine).append(lineBreak)
                    .toString();
            duckInfoMap.put(getDuckClassSimpleName(new RubberDuck()), rubberDuckInfo);

            String decoyDuckInfo = new StringBuilder()
                    .append(DuckConstants.LOOKS_LIKE_A_DECOY).append(lineBreak)
                    .append(DuckConstants.SPLASH).append(lineBreak)
                    .append(QuackBehaviorConstants.MUTE_QUACK).append(lineBreak)
                    .append(FlyBehaviorConstants.FLY_NO_WAY).append(lineBreak)
                    .append(dashedLine).append(lineBreak)
                    .toString();
            duckInfoMap.put(getDuckClassSimpleName(new DecoyDuck()), decoyDuckInfo);

            StringBuilder sb = new StringBuilder();
            for (Duck duck : ducks) {
                String duckClassAsString = getDuckClassSimpleName(duck);
                sb.append(duckClassAsString).append(lineBreak)
                    .append(duckInfoMap.get(duckClassAsString));
            }
            String expectedString = sb.toString().trim();

            duckTalesApplication.main(null);

            Assertions.assertEquals(expectedString, outputStreamCaptor.toString().trim());
        }

        private String getDuckClassSimpleName(Duck duck) {
            return duck.getClass().getSimpleName();
        }
    }
}
