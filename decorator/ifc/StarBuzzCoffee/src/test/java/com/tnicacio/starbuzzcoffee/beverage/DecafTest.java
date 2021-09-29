package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.beverage.Decaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecafTest {

    private Beverage decaf;

    @BeforeEach
    void setUp() {
        decaf = new Decaf();
    }

    @Test
    void shouldReturnDescriptionEqualToDecaf() {
        String result = decaf.getDescription();
        assertThat(result).isEqualTo("Decaf");
    }

    @Test
    void shouldReturnCostEqualTo105cents() {
        assertThat(decaf.cost()).isEqualTo(1.05);
    }

}