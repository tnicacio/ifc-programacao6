package com.tnicacio.starbuzzcoffee2000.beverage;

import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.coststrategy.HouseBlendCost;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public final class HouseBlend implements Beverage {

    private CostStrategy costStrategy;
    private Size size;

    public HouseBlend() {
        costStrategy = new HouseBlendCost();
    }

    @Override
    public String getDescription() {
        return "House Blend Coffee";
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
