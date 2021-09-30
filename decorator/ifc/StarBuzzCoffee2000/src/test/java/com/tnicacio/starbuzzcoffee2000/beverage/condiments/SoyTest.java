package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SoyTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Nested
    class Description {
        @Test
        void shouldDecorateBeverageAndReturnParentDescriptionPlusSoy() {
            beverage = new Soy(beverage);

            String result = beverage.getDescription();

            assertThat(result).doesNotStartWith("Soy");
            assertThat(result).endsWith("Soy");
        }
    }

    @Nested
    class Cost {

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus15CentsWhenSizeMedium() {
            beverage.setSize(Size.MEDIUM);
            double oldCost = beverage.cost();
            beverage = new Soy(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.15);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus10CentsWhenSizeSmall() {
            beverage.setSize(Size.SMALL);
            double oldCost = beverage.cost();
            beverage = new Soy(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.10);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus20CentsWhenSizeBig() {
            beverage.setSize(Size.BIG);
            double oldCost = beverage.cost();
            beverage = new Soy(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.20);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlusDefaultCostWhenSizeIsNotDefined() {
            double oldCost = beverage.cost();
            beverage.setSize(null);
            beverage = new Soy(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.15);
        }

    }

}