package com.tnicacio.starbuzzcoffee2000;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.beverage.DarkRoast;
import com.tnicacio.starbuzzcoffee2000.condimentdecorator.Milk;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.sizedecorator.SmallBeverage;

public class StarBuzzCoffee2000Application {

    public static void main(String... args) {

        System.out.println("Using beverage.setSize...");
        Beverage beverage = new DarkRoast();
        beverage.setSize(Size.SMALL);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost() + beverage.getDescription());

        System.out.println("Using size decorator...");
        Beverage beverage1 = new DarkRoast();
        beverage1 = new Milk(beverage1);
        beverage1 = new SmallBeverage(beverage1);
        System.out.println(beverage1.cost() + beverage1.getDescription());

    }

}
