package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseBlendTest {

    private Beverage houseBlend;

    @BeforeEach
    void setUp() {
        houseBlend = new HouseBlend();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToHouseBlendCoffee() {
            String result = houseBlend.getDescription();
            assertThat(result).isEqualTo("House Blend Coffee");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldReturn89centsWhenSizeMedium() {
            houseBlend.setSize(Size.MEDIUM);
            assertThat(houseBlend.cost()).isEqualTo(0.89);
        }

        @Test
        void shouldReturn79centsWhenSizeSmall() {
            houseBlend.setSize(Size.SMALL);
            assertThat(houseBlend.cost()).isEqualTo(.79);
        }

        @Test
        void shouldReturn99centsWhenSizeBig() {
            houseBlend.setSize(Size.BIG);
            assertThat(houseBlend.cost()).isEqualTo(.99);
        }

        @Test
        void shouldReturnDefaultSizeCostWhenSizeIsNotDefined() {
            houseBlend.setSize(null);
            assertThat(houseBlend.cost()).isEqualTo(.89);
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            houseBlend.setSize(Size.SMALL);
            assertThat(houseBlend.getSize()).isEqualTo(Size.SMALL);
        }

    }

}