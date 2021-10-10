package com.tnicacio.residentialremotecontroller.garagedoor.service;

import com.tnicacio.residentialremotecontroller.garagedoor.model.GarageDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GarageDoorServiceTest {

    private GarageDoorService service;
    private GarageDoor garageDoor;

    @BeforeEach
    void setUp() {
        garageDoor = new GarageDoor("Imaginary place");
        service = new GarageDoorService(garageDoor);
    }

    @Test
    void upShouldSetGarageDoorUp() {
        service.up();
        assertThat(garageDoor.isUp()).isTrue();
    }

    @Test
    void downShouldSetGarageDoorUpEqualToFalse() {
        service.down();
        assertThat(garageDoor.isUp()).isFalse();
    }

}
