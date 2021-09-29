package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.beverage.Espresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EspressoTest {

    private Beverage espresso;

    @BeforeEach
    void setUp() {
        espresso = new Espresso();
    }

    @Test
    void shouldReturnDescriptionEqualToEspresso() {
        String result = espresso.getDescription();
        assertThat(result).isEqualTo("Espresso");
    }

    @Test
    void shouldReturnCostEqualTo1999cents() {
        assertThat(espresso.cost()).isEqualTo(1.99);
    }

}