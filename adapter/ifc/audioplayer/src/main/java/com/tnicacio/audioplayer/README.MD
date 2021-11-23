# :notes: Audio Player

> Implementação de tocador de músicas utilizando o padrão Adapter.

## Problema 
Considere a construção de um programa para reprodução de arquivos de áudio
(player de música) com capacidade de reproduzir arquivos nos seguintes formatos:
mp3, wav e wma. Há uma classe específica para tratar os arquivos de áudio de cada
um dos formatos. As classes que processam arquivos nos formatos mp3 e
wav atendem (isto é, realizam) a interface AudioFormat:

```
public interface AudioFormat {

    void open(String name);
    void reproduce();
    void stop();

}
```

- O método *open* é utilizado para carregar um arquivo de áudio na memória.

- O método *reproduce* é utilizado para reproduzir o arquivo de áudio que foi carregado na memória pelo método *open()*.
A reprodução começa à partir do início do arquivo.

- O método *stop* é utilizado para fechar o arquivo, liberando a memória ocupada.

Já a reprodução de arquivos no formato wma utiliza a classe WmaPlay, que possui os seguintes métodos:

```
public interface WmaPlay {

    void setFile(String name);
    void open();
    void setLocation(int seconds);
    void play();
    void stop();

}
```

- O método *setFile* é utilizado para definir o nome do arquivo que será utilizado pelo objeto de reprodução de arquivos wma.
- O método *open* é utilizado para abrir o arquivo definido pelo método *setFile()*.
- O método *setLocation* é utilizado para indicar a posição do arquivo onde deve iniciar a reprodução do áudio. Para começar
à partir do início do arquivo, deve-se fornecer como argumento o valor 0.
- O método *play* é utilizado para reproduzir o arquivo aberto com o método *open()*. O arquivo de áudio começa a ser reproduzido
à partir da posição indicada pelo método *setLocation*.
- O método *stop* é utilizado para parar a reprodução do arquivo.

**Diante destas necessidades, pede-se:**

1. Utilizar o padrão de projeto Adapter para que seja possível incorporar a interface AudioFormat na reprodução de arquivos
no formato wma. *Obs*: a classe WmaPlay não pode ser modificada.
2. Elaborar o diagrama de classes da solução.
3. Cirar uma classe com o método *main* para demonstrar a utilização do adaptador da classe WmaPlay.


## Diagrama de classes da solução

