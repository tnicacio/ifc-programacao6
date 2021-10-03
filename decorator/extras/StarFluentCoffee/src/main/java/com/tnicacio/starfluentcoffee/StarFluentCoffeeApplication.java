package com.tnicacio.starfluentcoffee;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.beverage.DarkRoast;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.orderfluent.OrderFluent;

public class StarFluentCoffeeApplication {

    public static void main(String... args) {

        Beverage order = OrderFluent.beverage(new DarkRoast())
                .size(Size.BIG)
                .add(Condiment.MILK)
                .add(Condiment.MILK)
                .add(Condiment.MOCHA)
                .checkout();

        System.out.println("Order: " + order.getDescription()
                + "\nCost: " + order.cost());
    }

}
