# :candy: Gumball Machine

> Uma implementação, com Spring, da Gumball Machine utilizada para descrever o padrão de projeto State do livro Head First Design Patterns: A Brain-Friendly Guide.

Considere a implementação de uma máquina automática
para venda de bolinhas de borracha. O problema pode ser modelado como uma
máquina de estados, compreendendo, à princípio, os seguintes **estados**:

1. *Sem Crédito*: este é um estado de repouso, no qual a máquina aguarda o
recebimento de moedas. Neste estado nenhuma compra pode ser efetivada, e
também não se pode entregar bolinhas para o cliente;

2. *Com Crédito*: neste estado a máquina já recebeu uma moeda do usuário, estando 
portanto apta a efetivar a compra (caso o estoque da máquina seja maior que zero), 
ou devolver o crédito ao cliente;

3. *Esgotado*: neste estado a máquina está com o reservatório de bolinhas vazio,
não podendo efetivar compra ou entregar produto. Também não pode aceitar
moedas do comprador;

4. *Vendido*: estado representando a compra efetivada. Aqui, uma bolinha deve
ser entregue ao cliente, o estoque deve ser atualizado, e a máquina deve voltar
ao estado de espera;

5. *Vencedor*: semelhante ao estado anterior. Este estado corresponde a uma
venda sorteada em promoção, na qual o comprador ganha duas bolinhas ao
invés de uma. Este caso deve ocorrer em aproximadamente 10% das vendas.

## Interface
A interface da máquina (i.e. sua interação com o comprador ou com o cliente)
deve compreender as seguintes **ações**:

1. Inserir moeda: esta ação corresponde à inserção de crédito na máquina.

2. Ejetar moeda: corresponda a um pedido de devolução de crédito por parte do usuário;

3. Virar manivela: ação necessária para efetivar a compra e liberação de uma ou
(duas bolinhas em 10% das compras) caso haja crédito e estoque na máquina;

4. Entregar: ação interna da máquina, para liberar bolinha(s) caso haja crédito
e estoque (esta ação atualiza o estoque da máquina).

# Padrão de Projetos STATE

> O padrão *State* permite que um objeto altere seu comportamento quando muda o seu estado interno. 

Para implementação do padrão *State*, foi definida a interface State contendo um método para cada ação da máquina:

```
package com.tnicacio.gumball.states;

public interface State {

    void insertCoin();

    void ejectCoin();

    void turnCrank();

    void dispense();

}

```

Em seguida implementou-se uma classe concreta para cada um dos estados da máquina. Estas classes são responsáveis pelo comportamento
da máquina quando ela entra no estado correspondente. Abaixo tem-se um exemplo de classe que implementa a interface State.

```
package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;

public class SoldState implements State {

    private GumballMachineDto gumballMachine;

    public SoldState(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        throw new IllegalStateException("Please wait while your gumball is being dispensed!");
    }

    @Override
    public void ejectCoin() {
        throw new IllegalStateException("Crank already turned!");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("Turning again will not give you another gumball ;/");
    }

    @Override
    public void dispense() {
        long newGumballCount = gumballMachine.getNumberGumballs() - 1;
        gumballMachine.setNumberGumballs(newGumballCount);

        if (newGumballCount == 0) {
            gumballMachine.setStateType(StateType.SOLD_OUT);
        } else {
            gumballMachine.setStateType(StateType.NO_CREDIT);
        }
    }

}
```

# Quero testar, como faz?
## Localmente
Após clonar este repositório, basta executar ```mvn spring-boot:run``` na pasta raiz do projeto

## Serviço no Heroku
Podes utilizar a api já disponível em: https://ifc-gumball.herokuapp.com

## Rotas do CRUD

### **[POST]** /gumball-machines/{uuid}
- Insere uma nova máquina de chiclete com um número de chicletes maior ou igual a zero. Exemplo de corpo para requisição:
```
{
    "numberGumballs": 72
}
```

### **[GET]** /gumball-machines
Retorna, de forma paginada, as máquinas de chiclete cadastradas.

### **[GET]** /gumball-machines/{uuid}
Retorna a máquina de chiclete que possui o id {uuid}. 

### **[PUT]** /gumball-machines/{uuid}
Atualiza as informações de determinada máquina de chicletes que contém o uuid informado. Exemplo de corpo para requisição:
```
{
    "numberGumballs": 72,
    "stateType": "NO_CREDIT"
}
```

### **[DELETE]** /gumball-machines/{uuid}
Exclui a máquina de chicletes identificada pelo valor do uuid.

## Rotas das Ações

### **[PUT]** /gumball-machines/{uuid}/insert-coin
Dispara a ação *inserir moeda* na máquina de uuid informado.

### **[PUT]** /gumball-machines/{uuid}/eject-coin
Dispara a ação *ejetar moeda* na máquina de uuid informado.

### **[PUT]** /gumball-machines/{uuid}/turn-crank
Dispara a ação *virar manivela* na máquina de uuid informado.

### **[PUT]** /gumball-machines/{uuid}/dispense
Dispara a ação *entregar* na máquina de uuid informado.


# Demonstração das Funcionalidades
https://user-images.githubusercontent.com/50798315/141039069-a8961757-184c-4b1f-960d-d3a481deea41.mp4


