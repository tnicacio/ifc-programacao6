package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SoyTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusSoy() {
        beverage = new Soy(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Soy");
        assertThat(result).endsWith("Soy");
    }

    @Test
    void shouldDecorateBeverageAndReturnParentCostPlus15Cents() {
        double oldCost = beverage.cost();
        beverage = new Soy(beverage);

        double newCost = beverage.cost();

        assertThat(newCost).isEqualTo(oldCost + 0.15);
    }

}