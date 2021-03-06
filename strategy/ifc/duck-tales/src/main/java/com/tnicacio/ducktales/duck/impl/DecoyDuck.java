package com.tnicacio.ducktales.duck.impl;

import com.tnicacio.ducktales.duck.Duck;
import com.tnicacio.ducktales.behaviors.flybehavior.FlyNoWay;
import com.tnicacio.ducktales.behaviors.quackbehavior.MuteQuack;
import com.tnicacio.ducktales.enums.DuckConstants;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        setQuackBehavior(new MuteQuack());
        setFlyBehavior(new FlyNoWay());
    }

    @Override
    public void display() {
        System.out.println(DuckConstants.LOOKS_LIKE_A_DECOY);
    }

}
