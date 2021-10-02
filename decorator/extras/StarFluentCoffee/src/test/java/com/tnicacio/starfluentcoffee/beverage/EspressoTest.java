package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EspressoTest {

    private Beverage espresso;

    @BeforeEach
    void setUp() {
        espresso = new Espresso();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToEspresso() {
            String result = espresso.getDescription();
            assertThat(result).isEqualTo("Espresso");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldReturn199centsWhenSizeMedium() {
            espresso.setSize(Size.MEDIUM);
            assertThat(espresso.cost()).isEqualTo(1.99);
        }

        @Test
        void shouldReturn189centsWhenSizeSmall() {
            espresso.setSize(Size.SMALL);
            assertThat(espresso.cost()).isEqualTo(1.89);
        }

        @Test
        void shouldReturn209centsWhenSizeBig() {
            espresso.setSize(Size.BIG);
            assertThat(espresso.cost()).isEqualTo(2.09);
        }

        @Test
        void shouldReturnDefaultSizeCostWhenSizeIsNotDefined() {
            espresso.setSize(null);
            assertThat(espresso.cost()).isEqualTo(1.99);
        }

    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            espresso.setSize(Size.SMALL);
            assertThat(espresso.getSize()).isEqualTo(Size.SMALL);
        }

    }

}