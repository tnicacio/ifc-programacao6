package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecafTest {

    private Beverage decaf;

    @BeforeEach
    void setUp() {
        decaf = new Decaf();
    }

    @Nested
    class Description {

        @Test
        void shouldReturnDescriptionEqualToDecaf() {
            String result = decaf.getDescription();
            assertThat(result).isEqualTo("Decaf");
        }

    }

    @Nested
    class Cost {

        @Test
        void shouldReturn105centsWhenSizeMedium() {
            decaf.setSize(Size.MEDIUM);
            assertThat(decaf.cost()).isEqualTo(1.05);
        }

        @Test
        void shouldReturn95centsWhenSizeSmall() {
            decaf.setSize(Size.SMALL);
            assertThat(decaf.cost()).isEqualTo(.95);
        }

        @Test
        void shouldReturn115centsWhenSizeBig() {
            decaf.setSize(Size.BIG);
            assertThat(decaf.cost()).isEqualTo(1.15);
        }

        @Test
        void shouldReturnDefaultSizeCostWhenSizeIsNotDefined() {
            decaf.setSize(null);
            assertThat(decaf.cost()).isEqualTo(1.05);
        }
    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldSetSizeAndGetThisSizeWithGetSize() {
            decaf.setSize(Size.SMALL);
            assertThat(decaf.getSize()).isEqualTo(Size.SMALL);
        }

    }

}