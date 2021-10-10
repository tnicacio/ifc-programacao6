package com.tnicacio.starfluentcoffee.orderfluent;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderFluentTest {

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageIsNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> OrderFluent.beverage(null))
                .withMessage("Beverage is required");
    }

    @Test
    void shouldReturnANewOrderFluentImplObject() {
        Beverage ambeverage = Mockito.mock(Beverage.class);
        assertThat(OrderFluent.beverage(ambeverage)).isInstanceOf(OrderFluentImpl.class);
    }

}