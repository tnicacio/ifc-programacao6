package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.DecafCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class Decaf implements Beverage {

    private CostStrategy costStrategy;
    private Size size;

    public Decaf() {
        costStrategy = new DecafCost();
    }

    @Override
    public String getDescription() {
        return "Decaf";
    }

    @Override
    public double cost() {
        return costStrategy.cost(this);
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
