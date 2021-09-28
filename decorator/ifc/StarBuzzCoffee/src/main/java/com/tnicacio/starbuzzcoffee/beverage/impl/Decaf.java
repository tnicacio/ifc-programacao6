package com.tnicacio.starbuzzcoffee.beverage.impl;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Decaf implements Beverage {

    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }

}
