package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.EspressoCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public final class Espresso implements Beverage {

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

}
