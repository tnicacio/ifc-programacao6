package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WhipCostTest {

    private CostStrategy strategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        strategy = new WhipCost();
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
    void shouldReturnParentBeverageCostPlus06CentsWhenBeverageSizeIsSmall() {
        Mockito.when(beverage.getSize()).thenReturn(Size.SMALL);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .06);
    }

    @Test
    void shouldReturnParentBeverageCostPlus10CentsWhenBeverageSizeIsMedium() {
        Mockito.when(beverage.getSize()).thenReturn(Size.MEDIUM);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .10);
    }

    @Test
    void shouldReturnParentBeverageCostPlus14CentsWhenBeverageSizeIsBig() {
        Mockito.when(beverage.getSize()).thenReturn(Size.BIG);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .14);
    }

}