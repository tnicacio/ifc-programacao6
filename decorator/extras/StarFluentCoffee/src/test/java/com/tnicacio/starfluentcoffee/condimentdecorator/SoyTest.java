package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class SoyTest {

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusSoy() {
        Beverage beverage = Mockito.mock(Beverage.class);
        beverage = new Soy(beverage);

        String result = beverage.getDescription();

        assertThat(result).doesNotStartWith("Soy").endsWith("Soy");
    }

}