package com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior;

import com.tnicacio.ducktales.enums.QuackBehaviorConstants;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(QuackBehaviorConstants.SQUEAK);
    }

}
