package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
