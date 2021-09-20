package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.services.duckbehaviors.flybehavior.FlyWithWings;
import com.tnicacio.ducktales.services.duckbehaviors.quackbehavior.Quack;
import com.tnicacio.ducktales.entities.enums.DuckConstants;

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
