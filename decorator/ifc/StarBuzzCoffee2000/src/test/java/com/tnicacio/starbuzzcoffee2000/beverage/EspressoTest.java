package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.EspressoCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
        void shouldExecuteCostStrategyDarkRoastCostMethod() {
            espresso.setSize(Size.SMALL);
            CostStrategy costStrategy = new EspressoCost();

            assertThat(espresso.cost()).isEqualTo(costStrategy.cost(espresso));
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