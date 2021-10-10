package com.tnicacio.starbuzzcoffee2000.sizedecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.test.factory.BeverageDefaultImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MediumBeverageTest {

    @Test
    void shouldDecorateBeverageAndReturnParentDescriptionPlusBIG() {
        Beverage beverage = new BeverageDefaultImpl();
        beverage = new MediumBeverage(beverage);

        String result = beverage.getDescription();

        Assertions.assertThat(result).doesNotStartWith("MEDIUM").endsWith("MEDIUM");
    }

}