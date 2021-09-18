# Programação 6
Exercícios realizados para a disciplina de Programação 6 do Instituto Federal Catarinense.


# Padrões de Projeto em Java
## [AER-P6-P01: STRATEGY](https://github.com/tnicacio/ifc-programacao6/tree/main/AER-P6-P01)
### [Lagoa dos Patos](https://github.com/tnicacio/ifc-programacao6/tree/main/AER-P6-P01/DuckTales)
Implementar o modelo de Lagoa dos Patos do livro *Head First: Design Patterns - A Brain-Friendly Guide* de Freeman, E. e Robson, E.

### [Prefeitura](https://github.com/tnicacio/ifc-programacao6/tree/main/AER-P6-P01/Prefeitura)

Utilize o padrão STRATEGY implementar as classes necessárias para fazer cálculo de valor 
venal de imóveis dependendo de características dos mesmos. A Prefeitura quer definir o valor 
dos imóveis da cidade para posteriormente poder atribuir o valor do IPTU. Para isto ela dividiu 
a cidade em regiões (A, B e C). Casas e Aptos na região A tem um valor de 3000,00 o m2. Na 
região B o valor é de 1000,00 e na C 500,00. Para os Terrenos os valores definidos foram: 
região A = 1500,00; B = 750,00 e C = 200,00. Casas e Aptos são considerados imóveis com 
edificação e é acrescido 1000,00 por cômodo. Considerando o modelo de classes baixo, que 
utiliza o padrão Strategy, implemente as classes e crie uma pequena aplicação demonstrando 
a criação de imóveis e os seus respectivos valores venais.

### [Rent-A-Boat](https://github.com/tnicacio/ifc-programacao6/tree/main/AER-P6-P01/Prefeitura)

Uma empresa de locação de barcos trabalha com os seguintes modelos de embarcações: 
bateira, iate, canoa, jangada e barco a vela. Os dois primeiros modelos usam motor, os dois 
seguintes são movimentados a remos e o último à vela. Usando o padrão strategy crie e 
implemente um modelo de classes que, dado um determinado barco, informe como ele está se 
movimentando
