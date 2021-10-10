package com.tnicacio.starbuzzcoffee2000.test.factory;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.condimentdecorator.CondimentDecorator;
import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;

public class CondimentDecoratorDefaultImpl extends CondimentDecorator {

    public CondimentDecoratorDefaultImpl(Beverage beverage, CostStrategy costStrategy) {
        super(beverage, costStrategy);
    }

    @Override
    public String getDescription() {
        return "Condiment Decorator Default Test";
    }

}
