package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MilkCostTest {

    private CostStrategy strategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        strategy = new MilkCost();
        beverage = Mockito.mock(Beverage.class);
    }

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageSizeIsNotDefined() {
        Mockito.when(beverage.getSize()).thenReturn(null);

        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> strategy.cost(beverage))
                .withMessage("Beverage size must be defined");
    }

    @Test
    void shouldReturnParentBeverageCostPlus10CentsWhenBeverageSizeIsSmall() {
        Mockito.when(beverage.getSize()).thenReturn(Size.SMALL);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .10);
    }

    @Test
    void shouldReturnParentBeverageCostPlus15CentsWhenBeverageSizeIsMedium() {
        Mockito.when(beverage.getSize()).thenReturn(Size.MEDIUM);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .15);
    }

    @Test
    void shouldReturnParentBeverageCostPlus20CentsWhenBeverageSizeIsBig() {
        Mockito.when(beverage.getSize()).thenReturn(Size.BIG);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .20);
    }

}