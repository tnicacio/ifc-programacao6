# Star Fluent Coffee

Este projeto tem como base o exercício de implementação StarBuzzCoffee, do livro 
Head First Design Patterns: A Brain-Friendly Guide, para o estudo do padrão de projetos Decorator.

Contudo, com o objetivo de se aprofundar nos estudos, foram feitas algumas adaptações e se utilizou mais técnicas
além do padrão de projeto Decorator.


## Aplicação do padrão de projetos Decorator

A *decoração* das bebidas foi feita utilizando-se a classe abstrata *CondimentDecorator*, que além de estender
a interface Beverage, também possui uma referência para beverage.

Observe abaixo que em todos os métodos sobrescritos da interface Beverage, são passadas informações da referência
à beverage (ou a própria beverage), ao invés de se ter e utilizar uma variável local como 'private Size size', por exemplo,
dentro da classe.

Vide métodos *getSize*, *setSize* e *cost* abaixo.

```
public abstract class CondimentDecorator implements Beverage {

    protected Beverage beverage;

    ...

    @Deprecated
    public CondimentDecorator() {
    }

    public CondimentDecorator(Beverage beverage, ...) {
        this.beverage = beverage;
        ...
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public void setSize(Size size) {
        beverage.setSize(size);
    }

    @Override
    public double cost() {
        return costStrategy.cost(beverage);
    }

    ...

}
```

E os condimentos concretos, que herdam de CondimentDecorator, sobrescrevem os demais métodos de Beverage também
utilizando a referência à beverage e incorporando mais características, tal como no método *getDescription*.

```
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage, new MilkCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

}
```

## Padrão Strategy para os custos das bebidas

Utilizou-se o padrão de projetos Strategy para se calcular os custos das bebidas e seus condimentos.

```
public interface CostStrategy {

    double cost(Beverage beverage);

}

public class DarkRoastCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        // Calculation logic here...
    }

}
```

Todas as classes que implementaram a interface *Beverage* possuem uma referência para a estratégia de cálculo de custo.
Abaixo tem-se as classes DarkRoast (uma das bebidas iniciais), e Milk  (um possível condimento para as bebidas)
utilizando o padrão de projetos Strategy para o cálculo do custo da bebida.

```
public class DarkRoast implements Beverage {

    private CostStrategy costStrategy;
    private Size size;

    public DarkRoast() {
        costStrategy = new DarkRoastCost();
    }

    @Override
    public String getDescription() {
        return "Dark Roast";
    }

    @Override
    public double cost() {
        return costStrategy.cost(this);
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}

public interface Beverage {

    String getDescription();

    double cost();

    Size getSize();

    void setSize(Size size);

}

```

```
public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage, new MilkCost());
    }

    ...

}

public abstract class CondimentDecorator implements Beverage {

    protected Beverage beverage;

    private CostStrategy costStrategy;

    @Deprecated
    public CondimentDecorator() {
    }

    public CondimentDecorator(Beverage beverage, CostStrategy costStrategy) {
        this.beverage = beverage;
        setCostStrategy(costStrategy);
    }
    
    ...

    @Override
    public double cost() {
        return costStrategy.cost(beverage);
    }

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
```

## Interface fluente
A interface OrderFluent foi implementada com o objetivo de promover a fluência no processo de pedido de uma bebida. 

Inicia-se escolhendo a bebida (beverage) através do método *SizeOrder beverage(Beverage beverage)* 
que tem como retorno  o próximo passo da interface, que é a escolha do tamanho - traduzida pela utilização
do método *CheckoutOrder size(Size size)* que nos leva à interface CheckoutOrder. 
E em CheckoutOrder pode-se finalizar o pedido e se obter a bebida final através do método *checkout*.

Contudo, e se quiséssemos adicionar condimentos, como leite, leite de soja ou creme, à nossa bebida? 

Para isso, foi criada a interface *CondimentsOrder*, que possui o método *CheckoutOrder add(Condiment condiment)*.
E, fazendo com que a interface CheckoutOrder estenda CondimentsOrder, damos a possibilidade de ou adicionar um ou 
mais condimentos, ou realizar o *checkout* e finalizar o pedido.


```
public interface OrderFluent {

    static SizeOrder beverage(Beverage beverage) {
        Objects.requireNonNull(beverage, "Beverage is required");
        return new OrderFluent(beverage);
    }

    interface SizeOrder {
        CheckoutOrder size(Size size);
    }

    interface CondimentsOrder {
        CheckoutOrder add(Condiment condiment);
    }

    interface CheckoutOrder extends CondimentsOrder {
        Beverage checkout();
    }

}

```

E OrderFluentImpl é a classe concreta responsável por implementar a interface OrderFluent.

```
public class OrderFluentImpl implements OrderFluent.SizeOrder, OrderFluent.CondimentsOrder, OrderFluent.CheckoutOrder {

    private Beverage beverage;

    public OrderFluentImpl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public OrderFluent.CheckoutOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        beverage.setSize(size);
        return this;
    }

    @Override
    public OrderFluent.CheckoutOrder add(Condiment condiment) {
        beverage = CondimentDecoratorUtil.decorate(beverage, condiment);
        return this;
    }

    @Override
    public Beverage checkout() {
        return beverage;
    }

}
```

### E como ficou o processo do pedido de bebidas?

Basta começar passando a bebida inicial e as opções seguintes disponíveis são mostradas de acordo com as definidas 
na interface OrderFluent!

Veja abaixo que, após se definir a bebida inicial, obrigatoriamente deve-se definir o tamanho. E após isso pode-se 
adicionar um ou mais condimentos, ou realizar o checkout.

```
Beverage order = OrderFluent.beverage(new DarkRoast())
                .size(Size.BIG)
                .add(Condiment.MILK)
                .add(Condiment.MILK)
                .add(Condiment.MOCHA)
                .checkout();
                
Beverage order2 = OrderFluent.beverage(new Espresso())
                .size(Size.MEDIUM)
                .checkout();            
```

## Bônus

- Você conhece o projeto *Enumus*? Vale muito à pena dar uma conferida nele: https://github.com/alexradzin/enumus
E este meu projeto se inspirou na classe EnumMapValidator do Enumus para realizar validações no mapeamento da 
enumeração *Condiment* para fazer o processo de *decoração* das bebidas!

```
@UtilityClass
public class CondimentDecoratorUtil {

    public Beverage decorate(Beverage beverage, Condiment condiment) {
        Objects.requireNonNull(beverage, "Beverage must not be null");
        Objects.requireNonNull(condiment, "Condiment must not be null");

        Map<Condiment, Beverage> map = new EnumMap<>(Condiment.class);
        map.put(Condiment.MILK, new Milk(beverage));
        map.put(Condiment.MOCHA, new Mocha(beverage));
        map.put(Condiment.SOY, new Soy(beverage));
        map.put(Condiment.WHIP, new Whip(beverage));

        EnumMapValidatorUtil.validateKeys(Condiment.class, map, "Condiments map");
        return map.getOrDefault(condiment, beverage);
    }

}
```