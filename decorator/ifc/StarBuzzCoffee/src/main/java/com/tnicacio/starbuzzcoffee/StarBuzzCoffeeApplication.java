package com.tnicacio.starbuzzcoffee;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;
import com.tnicacio.starbuzzcoffee.beverage.decorators.condiments.Mocha;
import com.tnicacio.starbuzzcoffee.beverage.decorators.condiments.Soy;
import com.tnicacio.starbuzzcoffee.beverage.decorators.condiments.Whip;
import com.tnicacio.starbuzzcoffee.beverage.DarkRoast;
import com.tnicacio.starbuzzcoffee.beverage.Espresso;
import com.tnicacio.starbuzzcoffee.beverage.HouseBlend;

public class StarBuzzCoffeeApplication {

    public static void main(String[] args) {

        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new Whip(new Mocha(new Soy(new HouseBlend())));
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());

    }

}
