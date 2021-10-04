package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.HouseBlendCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        void shouldExecuteCostStrategyDarkRoastCostMethod() {
            houseBlend.setSize(Size.SMALL);
            CostStrategy costStrategy = new HouseBlendCost();

            assertThat(houseBlend.cost()).isEqualTo(costStrategy.cost(houseBlend));
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