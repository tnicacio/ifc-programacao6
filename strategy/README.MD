# #STRATEGY

Strategy is a behavioral design pattern that lets you define a
family of algorithms, put each of them into a separate class,
and make their objects interchangeable ([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).


## Structure

![strategy-structure](https://user-images.githubusercontent.com/50798315/135772953-0a49105d-d8c0-4f0e-875d-6b836f8c4540.png)

1. The Context maintains a reference to one of the concrete strategies and communicates with this object only via the strategy interface.

2. The Strategy interface is common to all concrete strategies. It declares a method the context uses to execute a strategy.

3. Concrete Strategies implement different variations of an algorithm the context uses.

5. The context calls the execution method on the linked strategy object each time it needs to run the algorithm. The context
doesn’t know what type of strategy it works with or how the algorithm is executed.

5. The Client creates a specific strategy object and passes it to the context. The context exposes a setter which lets clients
replace the strategy associated with the context at runtime


## Applicability

**Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch
from one algorithm to another during runtime.**

> The Strategy pattern lets you indirectly alter the object’s
behavior at runtime by associating it with different sub-objects
which can perform specific sub-tasks in different ways.

**Use the Strategy when you have a lot of similar classes that
only differ in the way they execute some behavior.**

> The Strategy pattern lets you extract the varying behavior into
a separate class hierarchy and combine the original classes
into one, thereby reducing duplicate code

**Use the pattern to isolate the business logic of a class from
the implementation details of algorithms that may not be as
important in the context of that logic.**

> The Strategy pattern lets you isolate the code, internal data,
and dependencies of various algorithms from the rest of the
code. Various clients get a simple interface to execute the
algorithms and switch them at runtime.

**Use the pattern when your class has a massive conditional
operator that switches between different variants of the same
algorithm.**

> The Strategy pattern lets you do away with such a conditional
by extracting all algorithms into separate classes, all of which
implement the same interface. The original object delegates
execution to one of these objects, instead of implementing all
variants of the algorithm.

## Some implementations

- :duck: [Lagoa dos Patos](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/DuckTales)

- :classical_building: [Prefeitura](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/Prefeitura)

- :boat: [Rent-A-Boat](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/RentABoat)

- :100: [~~Smooth~~ Math Operator](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/extras/MathOperator)

- :top: [Strategy Structure](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/extras/StrategyStructure)

- :credit_card: [Pay Pay](https://github.com/tnicacio/ifc-programacao6/edit/main/strategy/extras/PayPay)
