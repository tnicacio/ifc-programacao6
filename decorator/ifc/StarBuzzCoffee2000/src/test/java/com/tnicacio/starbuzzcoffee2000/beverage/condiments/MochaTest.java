package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MochaTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Nested
    class Description {
        @Test
        void shouldDecorateBeverageAndReturnParentDescriptionPlusMocha() {
            beverage = new Mocha(beverage);

            String result = beverage.getDescription();

            assertThat(result).doesNotStartWith("Mocha");
            assertThat(result).endsWith("Mocha");
        }
    }

    @Nested
    class Cost {

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus20CentsWhenSizeMedium() {
            beverage.setSize(Size.MEDIUM);
            double oldCost = beverage.cost();
            beverage = new Mocha(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.20);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus15CentsWhenSizeSmall() {
            beverage.setSize(Size.SMALL);
            double oldCost = beverage.cost();
            beverage = new Mocha(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.15);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus25CentsWhenSizeBig() {
            beverage.setSize(Size.BIG);
            double oldCost = beverage.cost();
            beverage = new Mocha(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.25);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlusDefaultCostWhenSizeIsNotDefined() {
            double oldCost = beverage.cost();
            beverage.setSize(null);
            beverage = new Mocha(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.20);
        }

    }

}