package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.coststrategy.DecafCost;
import com.tnicacio.starfluentcoffee.enums.Size;

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

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
