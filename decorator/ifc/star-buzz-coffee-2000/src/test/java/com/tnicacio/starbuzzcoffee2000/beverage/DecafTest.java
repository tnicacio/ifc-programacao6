package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.DecafCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecafTest {

    private Beverage decaf;

    @BeforeEach
    void setUp() {
        decaf = new Decaf();
    }

    @Nested
    class GetDescription {

        @Test
        void shouldReturnDescriptionEqualToDecaf() {
            String result = decaf.getDescription();
            assertThat(result).isEqualTo("Decaf");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldExecuteCostStrategyDarkRoastCostMethod() {
            decaf.setSize(Size.SMALL);
            CostStrategy costStrategy = new DecafCost();

            assertThat(decaf.cost()).isEqualTo(costStrategy.cost(decaf));
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