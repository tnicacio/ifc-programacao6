package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MilkTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Nested
    class Description {
        @Test
        void shouldDecorateBeverageAndReturnParentDescriptionPlusMilk() {
            beverage = new Milk(beverage);

            String result = beverage.getDescription();

            assertThat(result).doesNotStartWith("Milk").endsWith("Milk");
        }
    }

    @Nested
    class Cost {

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus10CentsWhenSizeMedium() {
            beverage.setSize(Size.MEDIUM);
            double oldCost = beverage.cost();
            beverage = new Milk(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.10);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus5CentsWhenSizeSmall() {
            beverage.setSize(Size.SMALL);
            double oldCost = beverage.cost();
            beverage = new Milk(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.05);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus15CentsWhenSizeBig() {
            beverage.setSize(Size.BIG);
            double oldCost = beverage.cost();
            beverage = new Milk(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.15);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlusDefaultCostWhenSizeIsNotDefined() {
            double oldCost = beverage.cost();
            beverage.setSize(null);
            beverage = new Milk(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.10);
        }

    }

}