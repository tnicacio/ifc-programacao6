package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class Decaf implements Beverage {

    private final Size DEFAULT_SIZE = Size.MEDIUM;
    private Size size;

    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public double cost() {
        if (size == Size.MEDIUM) {
            return 1.05;
        }
        if (size == Size.SMALL) {
            return .95;
        }
        if (size == Size.BIG) {
            return 1.15;
        }

        this.size = DEFAULT_SIZE;
        return cost();
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Size getSize() {
        return size;
    }

}
