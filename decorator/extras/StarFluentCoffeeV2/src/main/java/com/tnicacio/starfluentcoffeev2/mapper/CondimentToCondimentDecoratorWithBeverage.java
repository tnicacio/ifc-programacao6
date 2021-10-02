package com.tnicacio.starfluentcoffeev2.mapper;

import com.tnicacio.starfluentcoffeev2.beverage.Beverage;
import com.tnicacio.starfluentcoffeev2.condiment.*;
import com.tnicacio.starfluentcoffeev2.enums.Condiment;

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
