package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class MilkTest {

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusMilk() {
        Beverage beverage = Mockito.mock(Beverage.class);
        beverage = new Milk(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Milk").endsWith("Milk");
    }

}