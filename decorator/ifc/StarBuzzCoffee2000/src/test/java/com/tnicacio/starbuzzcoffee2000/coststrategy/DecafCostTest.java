package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.Decaf;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DecafCostTest {

    private CostStrategy costStrategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        costStrategy = new DecafCost();
        beverage = new Decaf();
    }

    @Test
    void shouldReturn105centsWhenSizeMedium() {
        beverage.setSize(Size.MEDIUM);
        assertThat(costStrategy.cost(beverage)).isEqualTo(1.05);
    }

    @Test
    void shouldReturn95centsWhenSizeSmall() {
        beverage.setSize(Size.SMALL);
        assertThat(costStrategy.cost(beverage)).isEqualTo(.95);
    }

    @Test
    void shouldReturn115centsWhenSizeBig() {
        beverage.setSize(Size.BIG);
        assertThat(costStrategy.cost(beverage)).isEqualTo(1.15);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageSizeIsNull() {
        beverage.setSize(null);
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> costStrategy.cost(beverage))
                .withMessage("Beverage size must be defined beforehand");

    }

}
