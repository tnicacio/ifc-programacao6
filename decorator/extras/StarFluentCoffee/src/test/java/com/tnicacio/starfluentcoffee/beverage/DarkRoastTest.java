package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.cost.CostStrategy;
import com.tnicacio.starfluentcoffee.cost.DarkRoastCost;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class DarkRoastTest {

    private Beverage darkRoast;

    @BeforeEach
    void setUp() {
        darkRoast = new DarkRoast();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToDarkRoast() {
            String result = darkRoast.getDescription();
            assertThat(result).isEqualTo("Dark Roast");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyMethod() {
            CostStrategy costStrategy = Mockito.mock(DarkRoastCost.class);
            DarkRoast darkRoast = Mockito.spy(DarkRoast.class);
            darkRoast.setSize(Size.SMALL);
            darkRoast.setCostStrategy(costStrategy);
            InOrder inOrder = Mockito.inOrder(darkRoast, costStrategy);

            darkRoast.cost();

            inOrder.verify(darkRoast).cost();
            inOrder.verify(costStrategy).cost(darkRoast);
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldReturnCostStrategyCost() {
            CostStrategy costStrategy = Mockito.mock(DarkRoastCost.class);
            DarkRoast darkRoast = Mockito.spy(DarkRoast.class);
            darkRoast.setSize(Size.SMALL);
            darkRoast.setCostStrategy(costStrategy);

            Assertions.assertThat(darkRoast.cost()).isEqualTo(costStrategy.cost(darkRoast));
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            darkRoast.setSize(Size.SMALL);
            assertThat(darkRoast.getSize()).isEqualTo(Size.SMALL);
        }

    }

}