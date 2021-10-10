package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.beverage.HouseBlend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseBlendTest {

    private Beverage houseBlend;

    @BeforeEach
    void setUp() {
        houseBlend = new HouseBlend();
    }

    @Test
    void shouldReturnDescriptionEqualToHouseBlendCoffee() {
        String result = houseBlend.getDescription();
        assertThat(result).isEqualTo("House Blend Coffee");
    }

    @Test
    void shouldReturnCostEqualTo89cents() {
        assertThat(houseBlend.cost()).isEqualTo(.89);
    }

}