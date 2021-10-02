package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class WhipCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        double cost = beverage.cost();

        switch (beverage.getSize()) {
            case SMALL:
                cost += .06;
                break;
            case MEDIUM:
                cost += .10;
                break;
            case BIG:
                cost += .14;
                break;
        }
        return cost;
    }

}
