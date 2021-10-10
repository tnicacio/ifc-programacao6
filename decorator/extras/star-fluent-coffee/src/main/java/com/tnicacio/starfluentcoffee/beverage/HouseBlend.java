package com.tnicacio.starfluentcoffee.beverage;

import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.coststrategy.HouseBlendCost;
import com.tnicacio.starfluentcoffee.enums.Size;

public class HouseBlend implements Beverage {

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

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
