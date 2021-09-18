package com.tnicacio.ducktales.services.duckbehaviors.quackbehavior;

import com.tnicacio.ducktales.entities.enums.QuackBehaviorConstants;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(QuackBehaviorConstants.SQUEAK);
    }

}
