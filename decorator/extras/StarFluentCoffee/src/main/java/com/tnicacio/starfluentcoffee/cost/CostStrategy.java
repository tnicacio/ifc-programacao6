package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

public interface CostStrategy {

    double cost(Beverage beverage);

}
