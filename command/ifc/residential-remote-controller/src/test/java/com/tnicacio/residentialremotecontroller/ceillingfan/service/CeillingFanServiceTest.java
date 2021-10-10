package com.tnicacio.residentialremotecontroller.ceillingfan.service;

import com.tnicacio.residentialremotecontroller.ceillingfan.model.CeillingFan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CeillingFanServiceTest {

    private CeillingFanService service;
    private CeillingFan ceillingFan;

    @BeforeEach
    void setUp() {
        ceillingFan = new CeillingFan("Imaginary place");
        service = new CeillingFanService(ceillingFan);
    }

    @Nested
    class HighSpeed {
        @Test
        void shouldSetCeillingFanOn() {
            service.highSpeed();
            assertThat(ceillingFan.isOn()).isTrue();
        }

        @Test
        void shouldSetCeillingSpeedEqualToHigh() {
            service.highSpeed();
            assertThat(ceillingFan.getSpeed()).isEqualTo(CeillingFan.Speed.HIGH);
        }
    }

    @Nested
    class MediumSpeed {
        @Test
        void shouldSetCeillingFanOn() {
            service.mediumSpeed();
            assertThat(ceillingFan.isOn()).isTrue();
        }

        @Test
        void shouldSetCeillingSpeedEqualToMedium() {
            service.mediumSpeed();
            assertThat(ceillingFan.getSpeed()).isEqualTo(CeillingFan.Speed.MEDIUM);
        }
    }

    @Nested
    class LowSpeed {
        @Test
        void shouldSetCeillingFanOn() {
            service.lowSpeed();
            assertThat(ceillingFan.isOn()).isTrue();
        }

        @Test
        void shouldSetCeillingSpeedEqualToLow() {
            service.lowSpeed();
            assertThat(ceillingFan.getSpeed()).isEqualTo(CeillingFan.Speed.LOW);
        }
    }

    @Nested
    class Off {
        @Test
        void shouldSetCeillingFanOnEqualToFalse() {
            service.off();
            assertThat(ceillingFan.isOn()).isFalse();
        }

        @Test
        void shouldSetCeillingSpeedEqualToNone() {
            service.off();
            assertThat(ceillingFan.getSpeed()).isEqualTo(CeillingFan.Speed.NONE);
        }
    }

}