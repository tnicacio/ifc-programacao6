package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class SoyCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        double cost = beverage.cost();

        switch (beverage.getSize()) {
            case SMALL:
                cost += .10;
                break;
            case MEDIUM:
                cost += .15;
                break;
            case BIG:
                cost += .20;
                break;
        }
        return cost;
    }

}
