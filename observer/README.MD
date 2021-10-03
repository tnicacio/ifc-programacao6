# #OBSERVER

>Também conhecido como: Observador, Assinante do evento, Event-Subscriber, Escutador, Listener

O Observer é um padrão de projeto comportamental que permite que você defina um mecanismo de assinatura para
notificar múltiplos objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando ([SHEVTS, 2021](https://refactoring.guru/pt-br/design-patterns/book)).

- [Estrutura](https://github.com/tnicacio/ifc-programacao6/blob/main/observer#estrutura)
- [Aplicabilidade](https://github.com/tnicacio/ifc-programacao6/blob/main/observer#aplicabilidade)
- [Algumas implementações](https://github.com/tnicacio/ifc-programacao6/blob/main/observer#algumas-implementações)

## Estrutura
![observer-structure](https://user-images.githubusercontent.com/50798315/135774059-4b3814b8-a090-41a2-8d4f-1f6bfc0d0bfe.png)

1. A **Publisher** manda eventos de interesse para outros objetos. Esses eventos ocorrem quando a publicadora muda seu estado
ou executa algum comportamento. As publicadoras contêm uma infraestrutura de inscrição que permite novos assinantes 
se juntarem aos atuais assinantes, ou deixarem a lista.

2. Quando um novo evento acontece, a publicadora percorre a lista de assinantes e chama o método de notificação declarado
na interface do assinante em cada um dos objetos assinantes.

3. A interface **Subscriber** declara a interface de notificação. Na maioria dos casos ela consiste de um único método ```update```. 
O método pode ter vários parâmetros que permitem à publicadora passar detalhes do evento junto com a atualização.

4. **Concrete Subscribers** realizam algumas ações em resposta às notificações enviadas pela publicadora. Todas essas classes
devem implementar a mesma interface para que a publicadora não fique acoplada a classes concretas.

5. Geralmente, assinantes precisam de alguma informação contextual para lidar com a atualização corretamente. Por esse
motivo, as publicadoras quase sempre passam algum dado de contexto como argumentos do método de notificação. 
A publicadora pode passar a si mesmo como um argumento, permitindo que o assinante recupere quaisquer dados diretamente.

6. O **Client** cria a publicadora e os objetos assinantes separadamente, e então registra os assinantes para as atualizações da
publicadora.

## Aplicabilidade

**Utilize o padrão Observer quando mudanças no estado de um objeto podem precisar mudar outros objetos, e o atual conjunto 
de objetos é desconhecido de antemão ou muda dinamicamente.**

> Você pode vivenciar esse problema ao se trabalhar com classes de interfaces gráficas do usuário. Por exemplo, você criou
classes de botões customizados, e quer deixar os clientes colocarem códigos customizados para seus botões para que
eles ativem sempre que os usuários apertarem um botão.
> 
> O padrão Observer permite que qualquer objeto que implemente a interface do assinante possa se inscrever para notificações 
de eventos em objetos da publicadora. Você pode adicionar o mecanismo de inscrição em seus botões, permitindo que o cliente 
coloque seu próprio código através de classes assinantes customizadas.

**Utilize o padrão quando alguns objetos em sua aplicação devem observar outros, mas apenas por um tempo limitado ou
em casos específicos.**

> A lista de inscrição é dinâmica, então assinantes podem entrar e sair da lista sempre que quiserem.


## Algumas implementações
- ⛅ [Weather-O-Rama](https://github.com/tnicacio/ifc-programacao6/tree/main/observer/ifc/WeatherORama)
