package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.cost.CostStrategy;
import com.tnicacio.starfluentcoffee.cost.EspressoCost;
import com.tnicacio.starfluentcoffee.enums.Size;

public class Espresso implements Beverage {

    private CostStrategy costStrategy;
    private Size size;

    public Espresso() {
        costStrategy = new EspressoCost();
    }

    @Override
    public String getDescription() {
        return "Espresso";
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
