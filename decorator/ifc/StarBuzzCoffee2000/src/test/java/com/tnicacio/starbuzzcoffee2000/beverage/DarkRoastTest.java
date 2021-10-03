package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.DarkRoastCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DarkRoastTest {

    private Beverage darkRoast;

    @BeforeEach
    void setUp() {
        darkRoast = new DarkRoast();
    }

    @Nested
    class GetDescription {

        @Test
        void shouldReturnDescriptionEqualToDarkRoast() {
            String result = darkRoast.getDescription();
            assertThat(result).isEqualTo("Dark Roast");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyDarkRoastCostMethod() {
            darkRoast.setSize(Size.SMALL);
            CostStrategy costStrategy = new DarkRoastCost();

            assertThat(darkRoast.cost()).isEqualTo(costStrategy.cost(darkRoast));
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