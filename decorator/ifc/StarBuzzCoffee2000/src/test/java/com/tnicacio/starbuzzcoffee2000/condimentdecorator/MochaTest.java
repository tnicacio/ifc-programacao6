package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.test.factory.BeverageDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MochaTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = new BeverageDefaultImpl();
    }

    @Nested
    class Description {
        @Test
        void shouldDecorateBeverageAndReturnParentDescriptionPlusMocha() {
            beverage = new Mocha(beverage);

            String result = beverage.getDescription();

            assertThat(result).doesNotStartWith("Mocha").endsWith("Mocha");
        }
    }

}