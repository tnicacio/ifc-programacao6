package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.DarkRoastCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public final class DarkRoast implements Beverage {

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

}
