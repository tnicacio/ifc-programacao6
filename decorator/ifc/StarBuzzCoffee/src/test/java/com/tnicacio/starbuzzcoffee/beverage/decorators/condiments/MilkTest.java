package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MilkTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusMilk() {
        beverage = new Milk(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Milk");
        assertThat(result).endsWith("Milk");
    }

    @Test
    void shouldDecorateBeverageAndReturnParentCostPlus10Cents() {
        double oldCost = beverage.cost();
        beverage = new Milk(beverage);

        double newCost = beverage.cost();

        assertThat(newCost).isEqualTo(oldCost + 0.10);
    }

}