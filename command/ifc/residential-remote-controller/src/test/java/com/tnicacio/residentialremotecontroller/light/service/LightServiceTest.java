package com.tnicacio.residentialremotecontroller.light.service;

import com.tnicacio.residentialremotecontroller.light.model.Light;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LightServiceTest {

    private LightService service;
    private Light light;

    @BeforeEach
    void setUp() {
        light = new Light("Imaginary place");
        service = new LightService(light);
    }

    @Test
    void onShouldSetLightOn() {
        service.on();
        assertThat(light.isOn()).isTrue();
    }

    @Test
    void offShouldSetLightOnEqualToFalse() {
        service.off();
        assertThat(light.isOn()).isFalse();
    }

}
