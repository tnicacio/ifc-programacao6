package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class DecafCostTest {

    private CostStrategy strategy;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        strategy = new DecafCost();
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
    void shouldReturn95centsWhenBeverageSizeIsSmall() {
        Mockito.when(beverage.getSize()).thenReturn(Size.SMALL);

        assertThat(strategy.cost(beverage)).isEqualTo(.95);
    }

    @Test
    void shouldReturn105centsWhenBeverageSizeIsMedium() {
        Mockito.when(beverage.getSize()).thenReturn(Size.MEDIUM);

        assertThat(strategy.cost(beverage)).isEqualTo(1.05);
    }

    @Test
    void shouldReturn115centsWhenBeverageSizeIsBig() {
        Mockito.when(beverage.getSize()).thenReturn(Size.BIG);

        assertThat(strategy.cost(beverage)).isEqualTo(1.15);
    }

}