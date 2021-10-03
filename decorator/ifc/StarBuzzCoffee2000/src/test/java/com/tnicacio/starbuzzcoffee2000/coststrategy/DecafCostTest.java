package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.DarkRoast;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DarkRoastCostTest {

    private DarkRoastCost darkRoastCost;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        darkRoastCost = new DarkRoastCost();
        beverage = new DarkRoast();
    }

    @Test
    void shouldReturn99centsWhenSizeMedium() {
        beverage.setSize(Size.MEDIUM);
        assertThat(darkRoastCost.cost(beverage)).isEqualTo(.99);
    }

    @Test
    void shouldReturn89centsWhenSizeSmall() {
        beverage.setSize(Size.SMALL);
        assertThat(darkRoastCost.cost(beverage)).isEqualTo(.89);
    }

    @Test
    void shouldReturn109centsWhenSizeBig() {
        beverage.setSize(Size.BIG);
        assertThat(darkRoastCost.cost(beverage)).isEqualTo(1.09);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageSizeIsNull() {
        beverage.setSize(null);
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> darkRoastCost.cost(beverage))
                .withMessage("Beverage size must be defined beforehand");

    }

}