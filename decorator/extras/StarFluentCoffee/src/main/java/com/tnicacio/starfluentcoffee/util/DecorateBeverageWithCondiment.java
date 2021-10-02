package com.tnicacio.starfluentcoffee.util;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.Milk;
import com.tnicacio.starfluentcoffee.condiment.Mocha;
import com.tnicacio.starfluentcoffee.condiment.Soy;
import com.tnicacio.starfluentcoffee.condiment.Whip;
import com.tnicacio.starfluentcoffee.enums.Condiment;

public class DecorateBeverageWithCondiment implements DecoratorUtil<Beverage, Condiment> {

    @Override
    public Beverage decorate(Beverage beverage, Condiment condiment) {
        switch (condiment) {
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
