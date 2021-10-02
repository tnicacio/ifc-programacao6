package com.tnicacio.starfluentcoffee.mapper;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.*;
import com.tnicacio.starfluentcoffee.enums.Condiment;

public class CondimentToCondimentDecoratorWithBeverage implements Mapper<Condiment, CondimentDecorator, Beverage> {

    @Override
    public CondimentDecorator map(Condiment type, Beverage beverage) {
        switch (type) {
            case MILK:
                return new Milk(beverage);
            case SOY:
                return new Soy(beverage);
            case MOCHA:
                return new Mocha(beverage);
            case WHIP:
                return new Whip(beverage);
        }
        return null;
    }
}
