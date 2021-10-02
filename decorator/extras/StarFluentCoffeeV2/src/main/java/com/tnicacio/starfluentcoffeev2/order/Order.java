//package com.tnicacio.starfluentcoffee.order;
//
//import com.tnicacio.starfluentcoffee.beverage.Beverage;
//import com.tnicacio.starfluentcoffee.condiment.CondimentDecorator;
//import com.tnicacio.starfluentcoffee.enums.Size;
//
//import java.util.Objects;
//
//public interface OrderWithCondiments {
//
//    static SizeOrder beverage(Beverage beverage) {
//        Objects.requireNonNull(beverage, "Beverage is required to the order");
//        return new OrderWithCondimentsFluent(beverage);
//    }
//
//    interface SizeOrder {
//        CondimentsOrder size(Size size);
//    }
//
//    interface CondimentsOrder {
//        CondimentsOrder add(CondimentDecorator condiment);
//    }
//
//    interface CostOrder extends CondimentsOrder {
//        double cost();
//    }
//}
