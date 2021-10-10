package com.tnicacio.starbuzzcoffee.beverage;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class HouseBlend implements Beverage {

    @Override
    public String getDescription() {
        return "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }

}
