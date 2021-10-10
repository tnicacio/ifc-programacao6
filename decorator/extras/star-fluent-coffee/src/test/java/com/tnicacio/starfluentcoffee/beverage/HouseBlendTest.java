package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.coststrategy.HouseBlendCost;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class HouseBlendTest {

    private Beverage houseBlend;

    @BeforeEach
    void setUp() {
        houseBlend = new HouseBlend();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToHouseBlendCoffee() {
            String result = houseBlend.getDescription();
            assertThat(result).isEqualTo("House Blend Coffee");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyMethod() {
            CostStrategy costStrategy = Mockito.mock(HouseBlendCost.class);
            HouseBlend houseBlend = Mockito.spy(HouseBlend.class);
            houseBlend.setSize(Size.SMALL);
            houseBlend.setCostStrategy(costStrategy);
            InOrder inOrder = Mockito.inOrder(houseBlend, costStrategy);

            houseBlend.cost();

            inOrder.verify(houseBlend).cost();
            inOrder.verify(costStrategy).cost(houseBlend);
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldReturnCostStrategyCost() {
            CostStrategy costStrategy = Mockito.mock(HouseBlendCost.class);
            HouseBlend houseBlend = Mockito.spy(HouseBlend.class);
            houseBlend.setSize(Size.SMALL);
            houseBlend.setCostStrategy(costStrategy);

            Assertions.assertThat(houseBlend.cost()).isEqualTo(costStrategy.cost(houseBlend));
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            houseBlend.setSize(Size.SMALL);
            assertThat(houseBlend.getSize()).isEqualTo(Size.SMALL);
        }

    }

}