package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.beverage.DarkRoast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DarkRoastTest {

    private Beverage darkRoast;

    @BeforeEach
    void setUp() {
        darkRoast = new DarkRoast();
    }

    @Test
    void shouldReturnDescriptionEqualToDarkRoast() {
        String result = darkRoast.getDescription();
        assertThat(result).isEqualTo("Dark Roast");
    }

    @Test
    void shouldReturnCostEqualTo99cents() {
        assertThat(darkRoast.cost()).isEqualTo(.99);
    }

}