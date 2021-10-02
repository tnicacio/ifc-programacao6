package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class MochaCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        double cost = beverage.cost();

        switch (beverage.getSize()) {
            case SMALL:
                cost += .15;
                break;
            case MEDIUM:
                cost += .20;
                break;
            case BIG:
                cost += .25;
                break;
        }
        return cost;
    }

}
