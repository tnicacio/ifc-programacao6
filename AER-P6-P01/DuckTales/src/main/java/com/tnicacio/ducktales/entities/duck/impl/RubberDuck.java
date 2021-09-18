package com.tnicacio.ducktales.entities.duck.impl;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.services.duckbehaviors.flybehavior.FlyNoWay;
import com.tnicacio.ducktales.services.duckbehaviors.quackbehavior.Squeak;
import com.tnicacio.ducktales.entities.enums.DuckConstants;

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
