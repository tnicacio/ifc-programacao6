# #DECORATOR

Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside
special wrapper objects that contain the behaviors ([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).

- [Structure](https://github.com/tnicacio/ifc-programacao6/blob/main/decorator/README.MD#structure)
- [Applicability](https://github.com/tnicacio/ifc-programacao6/blob/main/decorator/README.MD#applicability)
- [Some implementations](https://github.com/tnicacio/ifc-programacao6/blob/main/decorator/README.MD#some-implementations)


## Structure
![decorator-structure](https://user-images.githubusercontent.com/50798315/135775313-5e232e70-e0ba-4ae7-ab43-8725c44a03b5.png)

1. The **Component** declares the common interface for both wrappers and wrapped objects.

2. **Concrete Component** is a class of objects being wrapped. It defines the basic behavior, which can be altered by decorators.

3. The **Base Decorator** class has a field for referencing a wrapped object. The field’s type should be declared as the component
interface so it can contain both concrete components and decorators. The base decorator delegates all operations to the
wrapped object.

4. **Concrete Decorators** define extra behaviors that can be added to components dynamically. Concrete decorators override
methods of the base decorator and execute their behavior either before or after calling the parent method.

5. The **Client** can wrap components in multiple layers of decorators, as long as it works with all objects via the component
interface.


## Applicability

**Use the Decorator pattern when you need to be able to assign extra behaviors to objects at runtime without breaking the
code that uses these objects.**

> The Decorator lets you structure your business logic into layers, create a decorator for each layer and compose objects with
various combinations of this logic at runtime. The client code can treat all these objects in the same way, since they all follow a common interface.

**Use the pattern when it’s awkward or not possible to extend an object’s behavior using inheritance.**

> Many programming languages have the final keyword that can be used to prevent further extension of a class. For a final
class, the only way to reuse the existing behavior would be to wrap the class with your own wrapper, using the Decorator pattern.

## Some implementations

- :coffee: [Star Buzz Coffee](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/ifc/StarBuzzCoffee)

- :zap: [Star Buzz Coffee (with ~~Lasers~~ Sizes)](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/ifc/StarBuzzCoffee2000)

- # :star2: [Star Fluent Coffee](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/extras/StarFluentCoffee)
