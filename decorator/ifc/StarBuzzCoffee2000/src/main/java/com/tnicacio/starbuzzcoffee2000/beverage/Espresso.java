package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class Espresso implements Beverage {

    private final Size DEFAULT_SIZE = Size.MEDIUM;
    private Size size;

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        if (size == Size.MEDIUM) {
            return 1.99;
        }
        if (size == Size.SMALL) {
            return 1.89;
        }
        if (size == Size.BIG) {
            return 2.09;
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
