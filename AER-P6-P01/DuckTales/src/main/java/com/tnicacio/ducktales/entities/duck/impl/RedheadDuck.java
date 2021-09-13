package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.duck.behaviors.flybehavior.FlyWithWings;
import com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior.Quack;
import com.tnicacio.ducktales.enums.DuckConstants;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    public void display() {
        System.out.println(DuckConstants.LOOKS_LIKE_A_REDHEAD);
    }

}
