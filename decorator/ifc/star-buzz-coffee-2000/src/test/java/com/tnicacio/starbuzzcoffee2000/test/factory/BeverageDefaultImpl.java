package com.tnicacio.starbuzzcoffee2000.test.factory;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class BeverageDefaultImpl implements Beverage {

    private final Size DEFAULT_SIZE = Size.MEDIUM;
    private Size size;

    @Override
    public String getDescription() {
        return "Default Beverage";
    }

    @Override
    public double cost() {
        if (size == Size.MEDIUM) {
            return 1.00;
        }
        if (size == Size.SMALL) {
            return .90;
        }
        if (size == Size.BIG) {
            return 1.10;
        }
        size = DEFAULT_SIZE;
        return cost();
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

}
