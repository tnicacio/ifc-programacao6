# Star Fluent Coffee

Este projeto tem como base o exercício de implementação StarBuzzCoffee, do livro 
Head First Design Patterns: A Brain-Friendly Guide, para o estudo do padrão de projetos Decorator.

Contudo, com o objetivo de se aprofundar nos estudos, foram feitas algumas adaptações e se utilizou mais técnicas
além do padrão de projeto Decorator.


## Interface fluente
A interface Order foi implementada com o objetivo de promover a fluência no processo de pedido de uma bebida. 

Inicia-se escolhendo a bebida (beverage) através do método *SizeOrder Order.beverage(Beverage beverage)* 
que tem como retorno  o próximo passo da interface, que é a escolha do tamanho - traduzida pela utilização
do método *CheckoutOrder size(Size size)* que nos leva à interface CheckoutOrder. 
E em CheckoutOrder pode-se finalizar o pedido, através do método *checkout*.

Contudo, e se quiséssemos adicionar condimentos, como leite ou creme, à nossa bebida? 

Para isso, foi criada a interface *CondimentsOrder*, que possui o método *CheckoutOrder add(Condiment condiment)*.
E, fazendo com que a interface CheckoutOrder estenda CondimentsOrder, damos a possibilidade de se adicionar um ou 
mais condimentos, ou realizar o *checkout* e finalizar o pedido.


```
public interface Order {

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

E OrderFluent é a classe concreta responsável por implementar a interface Order.

```
    public class OrderFluent implements Order.SizeOrder, Order.CondimentsOrder, Order.CheckoutOrder {

    private Beverage beverage;

    public OrderFluent(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Order.CheckoutOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        beverage.setSize(size);
        return this;
    }

    @Override
    public Order.CheckoutOrder add(Condiment condiment) {
        beverage = CondimentDecoratorUtil.decorate(beverage, condiment);
        return this;
    }

    @Override
    public Beverage checkout() {
        return beverage;
    }

}
```

### Palhinha de como ficou fluente o processo de pedido de bebidas

```
Beverage order = Order.beverage(new DarkRoast())
                .size(Size.BIG)
                .add(Condiment.MILK)
                .add(Condiment.MILK)
                .add(Condiment.MOCHA)
                .checkout();
                
Beverage order2 = Order.beverage(new Espresso())
                .size(Size.MEDIUM)
                .checkout();            
```

## Padrão Strategy para os custos das bebidas

Utilizou-se o padrão de projetos Strategy para se calcular os custos das bebidas e seus condimentos.

```
public interface CostStrategy {

    double cost(Beverage beverage);

}
```

Todas as classes que implementaram a interface *Beverage* possuem uma referência para a estratégia de cálculo de custo.
Abaixo tem-se a classe DarkRoast que é uma das bebidas iniciais, e Milk - que é um possível condimento para bebidas.

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

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

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

    public void setCostStrategy(CostStrategy costStrategy) {
        this.costStrategy = costStrategy;
    }

}
```

## Bônus

- Você conhece o projeto *Enumus*? Vale muito à pena dar uma conferida nele: https://github.com/alexradzin/enumus
E este meu projeto se inspirou na classe EnumMapValidator do Enumus para realizar validações no processo de *decoração*
de bebidas com condimentos!

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