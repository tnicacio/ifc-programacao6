package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

public interface CostStrategy {

    double cost(Beverage beverage);

}
