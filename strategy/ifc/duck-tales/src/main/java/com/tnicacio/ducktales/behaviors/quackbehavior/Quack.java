package com.tnicacio.ducktales.behaviors.quackbehavior;

import com.tnicacio.ducktales.enums.QuackBehaviorConstants;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(QuackBehaviorConstants.QUACK);
    }

}
