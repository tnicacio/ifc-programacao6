package com.tnicacio.ducktales.entities.duck;

import com.tnicacio.ducktales.entities.duck.behaviors.flybehavior.FlyBehavior;
import com.tnicacio.ducktales.entities.duck.behaviors.quackbehavior.QuackBehavior;
import com.tnicacio.ducktales.enums.DuckConstants;

public abstract class Duck {

    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public void swim() {
        System.out.println(DuckConstants.SPLASH);
    };

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    // OTHER duck-like methods...
}
