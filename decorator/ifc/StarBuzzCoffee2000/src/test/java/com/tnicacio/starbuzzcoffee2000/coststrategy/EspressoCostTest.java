package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.Espresso;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EspressoCostTest {

    private CostStrategy costStrategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        costStrategy = new EspressoCost();
        beverage = new Espresso();
    }

    @Test
    void shouldReturn199centsWhenSizeMedium() {
        beverage.setSize(Size.MEDIUM);
        assertThat(costStrategy.cost(beverage)).isEqualTo(1.99);
    }

    @Test
    void shouldReturn189centsWhenSizeSmall() {
        beverage.setSize(Size.SMALL);
        assertThat(costStrategy.cost(beverage)).isEqualTo(1.89);
    }

    @Test
    void shouldReturn209centsWhenSizeBig() {
        beverage.setSize(Size.BIG);
        assertThat(costStrategy.cost(beverage)).isEqualTo(2.09);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageSizeIsNull() {
        beverage.setSize(null);
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> costStrategy.cost(beverage))
                .withMessage("Beverage size must be defined beforehand");

    }

}
