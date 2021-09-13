package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.duck.behaviors.flybehavior.FlyNoWay;
import com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior.Squeak;
import com.tnicacio.ducktales.enums.DuckConstants;

public class RubberDuck extends Duck {

    public RubberDuck() {
        setQuackBehavior(new Squeak());
        setFlyBehavior(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println(DuckConstants.LOOKS_LIKE_A_RUBBERDUCK);
    }

}
