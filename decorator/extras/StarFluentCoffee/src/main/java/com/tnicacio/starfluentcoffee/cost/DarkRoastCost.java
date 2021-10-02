package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class DarkRoastCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        switch (beverage.getSize()) {
            case SMALL:
                return .89;
            case MEDIUM:
                return .99;
            case BIG:
                return 1.09;
        }
        return 0.0;
    }

}
