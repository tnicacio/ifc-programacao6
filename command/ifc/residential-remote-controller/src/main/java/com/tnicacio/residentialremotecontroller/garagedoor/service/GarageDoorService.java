package com.tnicacio.residentialremotecontroller.garagedoor.service;

import com.tnicacio.residentialremotecontroller.garagedoor.model.GarageDoor;

public class GarageDoorService {

    private GarageDoor garageDoor;

    public GarageDoorService(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void up() {
        garageDoor.setUp(true);
    }

    public void down() {
        garageDoor.setUp(false);
    }

    @Override
    public String toString() {
        return garageDoor.toString();
    }

}
