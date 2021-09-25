package com.tnicacio.strategystructure;


import com.tnicacio.strategystructure.context.Context;
import com.tnicacio.strategystructure.strategies.FirstConcreteStrategy;
import com.tnicacio.strategystructure.strategies.SecondConcreteStrategy;
import com.tnicacio.strategystructure.strategies.Strategy;

/**
 * The Client creates a specific strategy object and passes it to
 * the context. The context exposes a setter which lets clients
 * replace the strategy associated with the context at runtime
 */
public class Client {

    public static void main(String... args) {
        Strategy firstStrategy = new FirstConcreteStrategy();
        Strategy secondStrategy = new SecondConcreteStrategy();

        Context context = new Context();

        context.setStrategy(firstStrategy);
        String result = context.doSomething("Some Data");
        System.out.println(result);

        context.setStrategy(secondStrategy);
        String otherResult = context.doSomething("Some Data");
        System.out.println(otherResult);
    }

}
