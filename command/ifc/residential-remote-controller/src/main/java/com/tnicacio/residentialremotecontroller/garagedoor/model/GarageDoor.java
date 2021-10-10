package com.tnicacio.residentialremotecontroller.garagedoor.model;

public class GarageDoor {

    private final String description;
    private boolean isUp;

    public GarageDoor(String description) {
        this.description = description;
        this.isUp = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }

    @Override
    public String toString() {
        return description + " garage door is " + (isUp() ? "up" : "down");
    }

}
