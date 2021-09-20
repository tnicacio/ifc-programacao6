package com.tnicacio.ducktales.services.duckbehaviors.flybehavior;

import com.tnicacio.ducktales.entities.enums.FlyBehaviorConstants;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println(FlyBehaviorConstants.FLY_NO_WAY);
    }

}
