package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.cost.CostStrategy;
import com.tnicacio.starfluentcoffee.enums.Size;

public abstract class CondimentDecorator implements Beverage {

    protected Beverage beverage;

    private CostStrategy costStrategy;

    public CondimentDecorator(Beverage beverage, CostStrategy costStrategy) {
        this.beverage = beverage;
        this.costStrategy = costStrategy;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public void setSize(Size size) {
        beverage.setSize(size);
    }

    @Override
    public double cost() {
        return costStrategy.cost(beverage);
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
