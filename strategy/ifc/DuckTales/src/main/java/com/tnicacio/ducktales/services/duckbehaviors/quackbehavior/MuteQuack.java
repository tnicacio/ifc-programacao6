package com.tnicacio.ducktales.services.duckbehaviors.quackbehavior;

import com.tnicacio.ducktales.entities.enums.QuackBehaviorConstants;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(QuackBehaviorConstants.MUTE_QUACK);
    }

}
