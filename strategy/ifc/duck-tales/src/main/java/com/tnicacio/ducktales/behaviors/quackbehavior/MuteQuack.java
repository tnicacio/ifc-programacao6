package com.tnicacio.ducktales.behaviors.quackbehavior;

import com.tnicacio.ducktales.enums.QuackBehaviorConstants;

public class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println(QuackBehaviorConstants.MUTE_QUACK);
    }

}
