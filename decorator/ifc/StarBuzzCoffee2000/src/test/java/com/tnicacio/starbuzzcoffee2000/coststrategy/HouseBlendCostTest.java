package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.Espresso;
import com.tnicacio.starbuzzcoffee2000.beverage.HouseBlend;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class HouseBlendCostTest {

    private CostStrategy costStrategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        costStrategy = new HouseBlendCost();
        beverage = new HouseBlend();
    }

    @Test
    void shouldReturn89centsWhenSizeMedium() {
        beverage.setSize(Size.MEDIUM);
        assertThat(costStrategy.cost(beverage)).isEqualTo(0.89);
    }

    @Test
    void shouldReturn79centsWhenSizeSmall() {
        beverage.setSize(Size.SMALL);
        assertThat(costStrategy.cost(beverage)).isEqualTo(0.79);
    }

    @Test
    void shouldReturn99centsWhenSizeBig() {
        beverage.setSize(Size.BIG);
        assertThat(costStrategy.cost(beverage)).isEqualTo(.99);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageSizeIsNull() {
        beverage.setSize(null);
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> costStrategy.cost(beverage))
                .withMessage("Beverage size must be defined beforehand");

    }

}
