package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.coststrategy.EspressoCost;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class EspressoTest {

    private Beverage espresso;

    @BeforeEach
    void setUp() {
        espresso = new Espresso();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToEspresso() {
            String result = espresso.getDescription();
            assertThat(result).isEqualTo("Espresso");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyMethod() {
            CostStrategy costStrategy = Mockito.mock(EspressoCost.class);
            Espresso espresso = Mockito.spy(Espresso.class);
            espresso.setSize(Size.SMALL);
            espresso.setCostStrategy(costStrategy);
            InOrder inOrder = Mockito.inOrder(espresso, costStrategy);

            espresso.cost();

            inOrder.verify(espresso).cost();
            inOrder.verify(costStrategy).cost(espresso);
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldReturnCostStrategyCost() {
            CostStrategy costStrategy = Mockito.mock(EspressoCost.class);
            Espresso espresso = Mockito.spy(Espresso.class);
            espresso.setSize(Size.SMALL);
            espresso.setCostStrategy(costStrategy);

            Assertions.assertThat(espresso.cost()).isEqualTo(costStrategy.cost(espresso));
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            espresso.setSize(Size.SMALL);
            assertThat(espresso.getSize()).isEqualTo(Size.SMALL);
        }

    }

}