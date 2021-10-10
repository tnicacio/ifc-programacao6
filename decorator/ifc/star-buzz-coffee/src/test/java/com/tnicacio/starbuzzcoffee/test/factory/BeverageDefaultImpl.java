package com.tnicacio.starbuzzcoffee.test.factory;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class BeverageDefaultImpl implements Beverage {

    @Override
    public String getDescription() {
        return "Default Beverage";
    }

    @Override
    public double cost() {
        return 1.0;
    }

}
