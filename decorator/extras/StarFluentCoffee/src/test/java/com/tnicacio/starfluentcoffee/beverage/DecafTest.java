package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.cost.CostStrategy;
import com.tnicacio.starfluentcoffee.cost.DecafCost;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class DecafTest {

    private Beverage decaf;

    @BeforeEach
    void setUp() {
        decaf = new Decaf();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToDecaf() {
            String result = decaf.getDescription();
            assertThat(result).isEqualTo("Decaf");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyMethod() {
            CostStrategy costStrategy = Mockito.mock(DecafCost.class);
            Decaf decaf = Mockito.spy(Decaf.class);
            decaf.setSize(Size.SMALL);
            decaf.setCostStrategy(costStrategy);
            InOrder inOrder = Mockito.inOrder(decaf, costStrategy);

            decaf.cost();

            inOrder.verify(decaf).cost();
            inOrder.verify(costStrategy).cost(decaf);
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldReturnCostStrategyCost() {
            CostStrategy costStrategy = Mockito.mock(DecafCost.class);
            Decaf decaf = Mockito.spy(Decaf.class);
            decaf.setSize(Size.SMALL);
            decaf.setCostStrategy(costStrategy);

            Assertions.assertThat(decaf.cost()).isEqualTo(costStrategy.cost(decaf));
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            decaf.setSize(Size.SMALL);
            assertThat(decaf.getSize()).isEqualTo(Size.SMALL);
        }

    }

}