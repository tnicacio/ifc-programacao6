# #Command
> Também conhecido como: Comando, Ação, Action, Transação,
Transaction

O Command é um padrão de projeto comportamental que
transforma um pedido em um objeto independente que
contém toda a informação sobre o pedido. Essa transformação
permite que você parametrize métodos com diferentes
pedidos, atrase ou coloque a execução do pedido em uma fila,
e suporte operações que não podem ser feitas 
([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).

- [Estrutura](https://github.com/tnicacio/ifc-programacao6/tree/main/command#estrutura)
- [Aplicabilidade](https://github.com/tnicacio/ifc-programacao6/blob/main/command#aplicabilidade)
- [Algumas implementações](https://github.com/tnicacio/ifc-programacao6/blob/main/command#algumas-implementações)

## Estrutura

![command-refactoring-guru](https://user-images.githubusercontent.com/50798315/136704240-11a47da6-b6da-4e9e-83fa-ffa143c86259.png)

1. A classe **Remetente** (ou invocadora, Invoker) é responsável por iniciar os pedidos. Essa classe deve ter um
   campo para armazenar a referência para um objeto comando. O remetente aciona aquele comando ao invés de enviar o 
   pedido diretamente para o destinatário. Observe que o remetente não é responsável por criar o objeto comando. 
   Geralmente ele é pré criado através de um construtor do cliente.

2. A interface **Comando** (Command) geralmente declara apenas um único método para executar o comando. Contudo, também pode possuir
   outro método para desfazer o comando.

3. **Comandos Concretos** (Concrete Commands) implementam vários tipos de pedidos. Um comando concreto não deve realizar 
   o trabalho por conta própria, mas passar a chamada para um dos objetos da lógica do negócio. 
   Contudo, para simplificar o código, essas classes podem ser fundidas. Os parâmetros necessários para executar
   um método em um objeto destinatário podem ser declarados como campos no comando concreto. Você pode tornar os 
   objetos comando imutáveis ao permitir que apenas inicializem esses campos através do construtor.

4. A classe **Destinatária** (Receiver) contém a lógica do negócio. Quase qualquer objeto pode servir como um destinatário.
   A maioria dos comandos apenas lida com os detalhes de como um pedido é passado para o destinatário, enquanto que o 
   destinatário em si executa o verdadeiro trabalho.

5. O **Cliente** (Client) cria e configura objetos comando concretos. O cliente deve passar todos os parâmetros do pedido, 
   incluindo uma instância do destinatário, para o construtor do comando. Após isso, o comando resultante pode ser 
   associado com um ou múltiplos destinatários.

## Aplicabilidade

**Utilize o padrão Command quando você quer parametrizar objetos com operações.**

> O padrão Command podem tornar uma chamada específica para um método em um objeto separado. Essa mudança abre
várias possibilidades de usos interessantes: você pode passar comandos como argumentos do método, armazená-los dentro
de outros objetos, trocar comandos ligados no momento de execução, etc.
>
> Aqui está um exemplo: você está desenvolvendo um componente GUI como um menu de contexto, e você quer que os
usuários sejam capazes de configurar os items do menu que aciona as operações quando um usuário clica em um item.

**Utilize o padrão Command quando você quer colocar operações em fila, agendar sua execução, ou executá-las
remotamente.**

> Como qualquer outro objeto, um comando pode ser serializado, o que significa convertê-lo em uma string que pode ser
facilmente escrita em um arquivo ou base de dados. Mais tarde a string pode ser restaurada no objeto comando inicial. 
Dessa forma você pode adiar e agendar execuções do comando. Mas isso não é tudo! Da mesma forma, você pode colocar em 
fila, fazer registro de log ou enviar comandos por uma rede.

**Utilize o padrão Command quando você quer implementar
operações reversíveis.**

> Embora haja muitas formas de implementar o desfazer/refazer, o padrão Command é talvez a mais popular de todas.
>
> Para ser capaz de reverter operações, você precisa implementar o histórico de operações realizadas. O histórico do
> comando é uma pilha que contém todos os objetos comando executados junto com seus backups do estado da aplicação
relacionados.
> 
> Esse método tem duas desvantagens. Primeiro, se não for fácil salvar o estado da aplicação por parte dela ser privada.
Esse problema pode ser facilmente mitigado com o padrão **Memento**.
> 
> Segundo, os backups de estado podem consumir uma considerável quantidade de RAM. Portanto, algumas vezes você pode
recorrer a uma implementação alternativa: ao invés de restaurar a um estado passado, o comando faz a operação inversa.
A operação reversa também cobra um preço: ela pode ter sua implementação difícil ou até impossível.

## Algumas implementações

- :man_cook: [Command Structure](https://github.com/tnicacio/ifc-programacao6/edit/main/command/extras/command-structure)
- :woman_cook: [Residential Remote Controller](https://github.com/tnicacio/ifc-programacao6/tree/main/command/ifc/residential-remote-controller)
