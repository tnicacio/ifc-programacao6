# #DECORATOR

> Também conhecido como: Decorador, Envoltório, Wrapper

O Decorator é um padrão de projeto estrutural que permite que você acople novos comportamentos para objetos ao 
colocá-los dentro de invólucros de objetos que contém os comportamentos ([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).

- [Estrutura](https://github.com/tnicacio/ifc-programacao6/tree/main/decorator#estrutura)
- [Aplicabilidade](https://github.com/tnicacio/ifc-programacao6/blob/main/decorator#aplicabilidade)
- [Algumas implementações](https://github.com/tnicacio/ifc-programacao6/blob/main/decorator#algumas-implementações)


## Estrutura
![decorator-structure](https://user-images.githubusercontent.com/50798315/135775313-5e232e70-e0ba-4ae7-ab43-8725c44a03b5.png)

1. O **Component** declara uma interface comum tanto para os envoltórios (wrappers) quanto para os objetos envolvidos (wrapped objects).

2. **Concrete Component** é uma classe de objetos que são envolvidos. Ela define o comportamento básico, que pode ser alterado por decoradores.

3. A class **Base Decorator** tem um campo para referenciar um objeto envolvido. O tipo do campo deve ser declarado assim
como a interface do componente, para que possa esse campo possa conter ambos os componentes concretos e os decoradores. 
O decorador base delega todas as operações para o objeto envolvido.

4. **Concrete Decorators** definem comportamentos adicionais que podem ser adicionados aos componentes dinamicamente. 
Os decoradores concretos sobrescrevem métodos do decorador base e executam seus comportamentos ou antes ou depois de chamarem o método pai. 

5. O **Client** pode envolver componentes em múltiplas camadas de decoradores, desde que trabalhe com todos os objetos através da interface do componente.

## Aplicabilidade

**Utilize o padrão Decorator quando você precisa ser capaz de prover comportamentos adicionais para objetos em tempo de
execução sem quebrar o código que usa esses objetos.**

> O Decorator lhe permite estruturar sua lógica de negócio em camadas, criar um decorador para cada camada, e compor objetos com várias combinações dessa lógica durante a execução. O código cliente pode tratar de todos esses objetos da mesma forma, já que todos seguem a mesma interface comum.

**Utilize o padrão quando é complicado ou impossível estender o comportamento de um objeto usando herança**

> Muitas linguagens de programação possuem a palavra chave ```final``` que pode ser usada para prevenir a extensão de uma
classe. Para uma classe final, a única maneira de reutilizar seu comportamento existente seria envolver a classe com seu próprio invólucro usando o padrão Decorator

## Algumas implementações

- :coffee: [Star Buzz Coffee](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/ifc/StarBuzzCoffee)

- :zap: [Star Buzz Coffee (with ~~Lasers~~ Sizes)](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/ifc/StarBuzzCoffee2000)

- :star2: [Star Fluent Coffee](https://github.com/tnicacio/ifc-programacao6/edit/main/decorator/extras/star-fluent-coffee)
