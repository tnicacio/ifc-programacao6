package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.cost.CostStrategy;
import com.tnicacio.starfluentcoffee.cost.DarkRoastCost;
import com.tnicacio.starfluentcoffee.enums.Size;

public class DarkRoast implements Beverage {

    private final CostStrategy costStrategy;
    private Size size;

    public DarkRoast() {
        costStrategy = new DarkRoastCost();
    }

    @Override
    public String getDescription() {
        return "Dark Roast";
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
