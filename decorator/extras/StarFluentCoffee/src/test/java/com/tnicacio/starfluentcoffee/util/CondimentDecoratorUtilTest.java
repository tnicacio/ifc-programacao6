package com.tnicacio.starfluentcoffee.util;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CondimentDecoratorUtilTest {

    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = Mockito.mock(Beverage.class);
    }

    @Test
    void shouldDecorateBeverageWithMilkWhenCondimentIsMilk() {
        Beverage decorated = CondimentDecoratorUtil.decorate(beverage, Condiment.MILK);
        Assertions.assertThat(decorated.getDescription())
                .doesNotStartWith("Milk")
                .endsWith("Milk");
    }

    @Test
    void shouldDecorateBeverageWithSoyWhenCondimentIsSoy() {
        Beverage decorated = CondimentDecoratorUtil.decorate(beverage, Condiment.SOY);
        Assertions.assertThat(decorated.getDescription())
                .doesNotStartWith("Soy")
                .endsWith("Soy");
    }

    @Test
    void shouldDecorateBeverageWithMochaWhenCondimentIsMocha() {
        Beverage decorated = CondimentDecoratorUtil.decorate(beverage, Condiment.MOCHA);
        Assertions.assertThat(decorated.getDescription())
                .doesNotStartWith("Mocha")
                .endsWith("Mocha");
    }

    @Test
    void shouldDecorateBeverageWithWhipWhenCondimentIsWhip() {
        Beverage decorated = CondimentDecoratorUtil.decorate(beverage, Condiment.WHIP);
        Assertions.assertThat(decorated.getDescription())
                .doesNotStartWith("Whip")
                .endsWith("Whip");
    }

    @Test
    void shouldThrowNullPointerExceptionWhenCondimentIsNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> CondimentDecoratorUtil.decorate(beverage, null))
                .withMessage("Condiment must not be null");
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageIsNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> CondimentDecoratorUtil.decorate(null, Condiment.MOCHA))
                .withMessage("Beverage must not be null");
    }

}