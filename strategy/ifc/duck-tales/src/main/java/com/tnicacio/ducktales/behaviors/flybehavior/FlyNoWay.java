package com.tnicacio.ducktales.behaviors.flybehavior;

import com.tnicacio.ducktales.enums.FlyBehaviorConstants;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println(FlyBehaviorConstants.FLY_NO_WAY);
    }

}
