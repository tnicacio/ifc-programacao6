package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class DecafCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        switch (beverage.getSize()) {
            case SMALL:
                return .95;
            case MEDIUM:
                return 1.05;
            case BIG:
                return 1.15;
        }
        return 0.0;
    }

}
