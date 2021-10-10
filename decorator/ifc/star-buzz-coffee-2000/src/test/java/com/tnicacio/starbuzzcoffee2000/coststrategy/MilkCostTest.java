package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
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
                .withMessage("Beverage size must be defined beforehand");
    }

    @Test
    void shouldReturnParentBeverageCostPlus05CentsWhenBeverageSizeIsSmall() {
        Mockito.when(beverage.getSize()).thenReturn(Size.SMALL);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .05);
    }

    @Test
    void shouldReturnParentBeverageCostPlus10CentsWhenBeverageSizeIsMedium() {
        Mockito.when(beverage.getSize()).thenReturn(Size.MEDIUM);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .10);
    }

    @Test
    void shouldReturnParentBeverageCostPlus15CentsWhenBeverageSizeIsBig() {
        Mockito.when(beverage.getSize()).thenReturn(Size.BIG);

        assertThat(strategy.cost(beverage)).isEqualTo(beverage.cost() + .15);
    }

}
