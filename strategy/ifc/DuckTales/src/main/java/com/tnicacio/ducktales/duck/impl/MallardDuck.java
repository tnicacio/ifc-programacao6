package com.tnicacio.ducktales.duck.impl;

import com.tnicacio.ducktales.duck.Duck;
import com.tnicacio.ducktales.behaviors.flybehavior.FlyWithWings;
import com.tnicacio.ducktales.behaviors.quackbehavior.Quack;
import com.tnicacio.ducktales.enums.DuckConstants;

public class MallardDuck extends Duck {

    public MallardDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println(DuckConstants.LOOKS_LIKE_A_MALLARD);;
    }
}
