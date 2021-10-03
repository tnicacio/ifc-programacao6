package com.tnicacio.starbuzzcoffee2000;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.DarkRoast;
import com.tnicacio.starbuzzcoffee2000.condimentdecorator.Milk;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class StarBuzzCoffee2000Application {

    public static void main(String... args) {

        Beverage beverage = new DarkRoast();
        beverage.setSize(Size.SMALL);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());

    }

}
