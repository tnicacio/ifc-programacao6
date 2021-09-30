package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class DarkRoastTest {

    private Beverage darkRoast;

    @BeforeEach
    void setUp() {
        darkRoast = new DarkRoast();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToDarkRoast() {
            String result = darkRoast.getDescription();
            assertThat(result).isEqualTo("Dark Roast");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldReturn99centsWhenSizeMedium() {
            darkRoast.setSize(Size.MEDIUM);
            assertThat(darkRoast.cost()).isEqualTo(.99);
        }

        @Test
        void shouldReturn89centsWhenSizeSmall() {
            darkRoast.setSize(Size.SMALL);
            assertThat(darkRoast.cost()).isEqualTo(.89);
        }

        @Test
        void shouldReturn109centsWhenSizeBig() {
            darkRoast.setSize(Size.BIG);
            assertThat(darkRoast.cost()).isEqualTo(1.09);
        }

        @Test
        void shouldReturnDefaultSizeCostWhenSizeIsNotDefined() {
            darkRoast.setSize(null);
            assertThat(darkRoast.cost()).isEqualTo(.99);
        }
    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            darkRoast.setSize(Size.SMALL);
            assertThat(darkRoast.getSize()).isEqualTo(Size.SMALL);
        }

    }

}