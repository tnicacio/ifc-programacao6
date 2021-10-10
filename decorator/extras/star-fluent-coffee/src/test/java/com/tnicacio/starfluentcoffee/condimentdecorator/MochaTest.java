package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class MochaTest {

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusMocha() {
        Beverage beverage = Mockito.mock(Beverage.class);
        beverage = new Mocha(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Mocha").endsWith("Mocha");
    }

}