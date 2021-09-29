package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class MochaTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusMocha() {
        beverage = new Mocha(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Mocha");
        assertThat(result).endsWith("Mocha");
    }

    @Test
    void shouldDecorateBeverageAndReturnParentCostPlus20Cents() {
        double oldCost = beverage.cost();
        beverage = new Mocha(beverage);

        double newCost = beverage.cost();

        assertThat(newCost).isEqualTo(oldCost + 0.20);
    }

}