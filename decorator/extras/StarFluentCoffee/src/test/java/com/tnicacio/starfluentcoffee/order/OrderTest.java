package com.tnicacio.starfluentcoffee.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderTest {

    @Test
    void shouldThrowNullPointerExceptionWhenBeverageIsNull() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> Order.beverage(null))
                .withMessage("Beverage is required");
    }

    @Test
    void shouldReturnANewOrderFluentObject() {
        Beverage ambeverage = Mockito.mock(Beverage.class);
        assertThat(Order.beverage(ambeverage)).isInstanceOf(OrderFluent.class);
    }

}