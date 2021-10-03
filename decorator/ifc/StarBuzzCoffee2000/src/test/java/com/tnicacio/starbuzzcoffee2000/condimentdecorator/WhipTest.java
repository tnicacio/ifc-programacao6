package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WhipTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Nested
    class Description {
        @Test
        void shouldDecorateBeverageAndReturnParentDescriptionPlusWhip() {
            beverage = new Whip(beverage);

            String result = beverage.getDescription();

            assertThat(result).doesNotStartWith("Whip");
            assertThat(result).endsWith("Whip");
        }
    }

    @Nested
    class Cost {

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus10CentsWhenSizeMedium() {
            beverage.setSize(Size.MEDIUM);
            double oldCost = beverage.cost();
            beverage = new Whip(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.10);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus6CentsWhenSizeSmall() {
            beverage.setSize(Size.SMALL);
            double oldCost = beverage.cost();
            beverage = new Whip(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.06);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlus14CentsWhenSizeBig() {
            beverage.setSize(Size.BIG);
            double oldCost = beverage.cost();
            beverage = new Whip(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.14);
        }

        @Test
        void shouldDecorateBeverageAndReturnParentCostPlusDefaultCostWhenSizeIsNotDefined() {
            double oldCost = beverage.cost();
            beverage.setSize(null);
            beverage = new Whip(beverage);

            double newCost = beverage.cost();

            assertThat(newCost).isEqualTo(oldCost + 0.10);
        }

    }

}