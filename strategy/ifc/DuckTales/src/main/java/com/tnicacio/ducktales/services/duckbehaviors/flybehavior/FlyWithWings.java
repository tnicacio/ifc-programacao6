package com.tnicacio.ducktales.services.duckbehaviors.flybehavior;

import com.tnicacio.ducktales.entities.enums.FlyBehaviorConstants;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println(FlyBehaviorConstants.FLY_WITH_WINGS);
    }

}
