package com.tnicacio.starbuzzcoffee.beverage.impl;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Espresso implements Beverage {

    @Override
    public String getDescription() {
        return "Expresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

}
