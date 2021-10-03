package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

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

}
