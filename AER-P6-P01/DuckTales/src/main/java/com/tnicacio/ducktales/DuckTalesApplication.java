package com.tnicacio.ducktales;

import com.tnicacio.ducktales.entities.duck.Duck;
import com.tnicacio.ducktales.entities.duck.impl.DecoyDuck;
import com.tnicacio.ducktales.entities.duck.impl.MallardDuck;
import com.tnicacio.ducktales.entities.duck.impl.RedheadDuck;
import com.tnicacio.ducktales.entities.duck.impl.RubberDuck;

import java.util.List;

public class DuckTalesApplication {

    public static void main(String[] args) {

        List<Duck> ducksToTest = List.of(
                new MallardDuck(),
                new RedheadDuck(),
                new RubberDuck(),
                new DecoyDuck()
            );

        printInfoFromListOfDuckImplementations(ducksToTest);
    }

    private static void printInfoFromListOfDuckImplementations(List<Duck> ducks) {
        ducks.forEach(DuckTalesApplication::printInfoFromDuckImplementation);
    }

    private static void printInfoFromDuckImplementation(Duck duck) {
        System.out.println(duck.getClass().getSimpleName());
        duck.display();
        duck.swim();
        duck.performQuack();
        duck.performFly();
        System.out.println("---------");
    }
}
