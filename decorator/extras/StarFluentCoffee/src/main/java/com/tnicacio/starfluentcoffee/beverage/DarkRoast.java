package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.coststrategy.DarkRoastCost;
import com.tnicacio.starfluentcoffee.enums.Size;

public class DarkRoast implements Beverage {

    private CostStrategy costStrategy;
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

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
