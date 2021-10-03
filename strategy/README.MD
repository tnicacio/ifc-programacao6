# #STRATEGY

O Strategy é um padrão de projeto comportamental que permite que você defina uma família de algoritmos,
coloque-os em classes separadas, e faça os objetos deles intercambiáveis ([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).

- [Estrutura](https://github.com/tnicacio/ifc-programacao6/blob/main/strategy#estrutura)
- [Aplicabilidade](https://github.com/tnicacio/ifc-programacao6/blob/main/strategy#aplicabilidade)
- [Algumas implementações](https://github.com/tnicacio/ifc-programacao6/blob/main/strategy#algumas-implementacoes)


## Estrutura

![strategy-structure](https://user-images.githubusercontent.com/50798315/135772953-0a49105d-d8c0-4f0e-875d-6b836f8c4540.png)

1. O **Context** mantém uma referência para uma das estratégias concretas e se comunica com esse objeto através da interface da estratégia.

2. A interface **Strategy** é comum à todas as estratégias concretas. Ela declara um método que o contexto usa para executar uma estratégia.

3. **Concrete Strategies** implementam diferentes variações de um algoritmo que o contexto usa.

4. O contexto chama o método de execução no objeto estratégia ligado cada vez que ele precisa rodar um algoritmo. O contexto
não sabe qual tipo de estratégia ele está trabalhando ou como o algoritmo é executado.

5. O **Client** cria um objeto estratégia específico e passa ele para o contexto. O contexto expõe um setter que permite o cliente mudar 
a estratégia associada com contexto durante a execução


## Aplicabilidade

**Utilize o padrão Strategy quando você quer usar diferentes variações de um algoritmo dentro de um objeto, e ser capaz de
trocar de um algoritmo para outro durante a execução.**

> O padrão Strategy permite que você altere indiretamente o comportamento de um objeto durante a execução ao associá-lo a 
diferentes sub-objetos que pode fazer sub-tarefas específicas em diferentes formas.

**Utilize o Strategy quando você tem muitas classes parecidas que somente se diferenciam na forma em que executam algum comportamento.**

> O padrão Strategy permite que você extraia o comportamento variante para uma hierarquia de classe separada e combine
as classes originais em uma, levando a redução de código duplicado.

**Utilize o padrão para isolar a lógica do negócio de uma classe, dos detalhes de implementação de algoritmos que podem não
ser tão importantes no contexto da lógica.**

> O padrão Strategy permite que você isole o código, dados internos, e dependências de vários algoritmos, do restante do
código. Vários clientes podem obter uma simples interface para executar os algoritmos e trocá-los durante a execução do programa.

**Utilize o padrão quando sua classe tem um operador condicional muito grande que alterna entre diferentes variações do
mesmo algoritmo.**

> O padrão Strategy permite que você se livre dessa condicional ao extrair todos os algoritmos para classes separadas, todos 
eles implementando a mesma interface. O objeto original delega a execução de um desses objetos, ao invés de implementar todas as variações do algoritmo.


## Algumas implementações

- :duck: [Lagoa dos Patos](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/DuckTales)

- :classical_building: [Prefeitura](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/Prefeitura)

- :boat: [Rent-A-Boat](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/ifc/RentABoat)

- :100: [~~Smooth~~ Math Operator](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/extras/MathOperator)

- :top: [Strategy Structure](https://github.com/tnicacio/ifc-programacao6/tree/main/strategy/extras/StrategyStructure)

- :credit_card: [Pay Pay](https://github.com/tnicacio/ifc-programacao6/edit/main/strategy/extras/PayPay)
