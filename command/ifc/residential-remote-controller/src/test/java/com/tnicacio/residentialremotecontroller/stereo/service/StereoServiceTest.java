package com.tnicacio.residentialremotecontroller.stereo.service;

import com.tnicacio.residentialremotecontroller.stereo.model.Stereo;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StereoServiceTest {

    private StereoService service;
    private Stereo stereo;

    @BeforeEach
    void setUp() {
        stereo = new Stereo("Imaginary place");
        service = new StereoService(stereo);
    }

    @Nested
    class On {
        @Test
        void shouldSetStereoOn() {
            service.on();
            assertThat(stereo.isOn()).isTrue();
        }
    }

    @Nested
    class Off {
        @Test
        void shouldSetStereoVolumeEqualToZero() {
            service.off();
            assertThat(stereo.getVolume()).isZero();
        }

        @Test
        void shouldSetStereoCDEqualToFalse() {
            service.off();
            assertThat(stereo.isCD()).isFalse();
        }

        @Test
        void shouldSetStereoDVDEqualToFalse() {
            service.off();
            assertThat(stereo.isDVD()).isFalse();
        }

        @Test
        void shouldSetStereoRadioEqualToFalse() {
            service.off();
            assertThat(stereo.isRadio()).isFalse();
        }

        @Test
        void shouldSetStereoOnEqualToFalse() {
            service.off();
            assertThat(stereo.isOn()).isFalse();
        }
    }

    @Nested
    class OnWithCD {
        @Test
        void shouldSetStereoOn() {
            service.onWithCD();
            assertThat(stereo.isOn()).isTrue();
        }

        @Test
        void shouldSetStereoCD() {
            service.onWithCD();
            assertThat(stereo.isCD()).isTrue();
        }

        @Test
        void shouldSetStereoVolumeEqualToEleven() {
            service.onWithCD();
            assertThat(stereo.getVolume()).isEqualTo(11);
        }
    }

}