package com.tnicacio.starfluentcoffee.test.factory;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condimentdecorator.CondimentDecorator;

public class CondimentDecoratorDefaultImpl extends CondimentDecorator {

    public CondimentDecoratorDefaultImpl(Beverage beverage) {
        super(beverage, bev -> 42.0);
    }

    @Override
    public String getDescription() {
        return "Condiment default";
    }

}
