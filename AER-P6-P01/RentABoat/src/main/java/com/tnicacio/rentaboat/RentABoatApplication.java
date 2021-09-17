package com.tnicacio.rentaboat;

import com.tnicacio.rentaboat.entities.embarcacao.Embarcacao;
import com.tnicacio.rentaboat.entities.embarcacao.impl.Jangada;

public class RentABoatApplication {

    /*
    Uma empresa de locação de barcos trabalha com os seguintes modelos de embarcações:
    bateira, iate, canoa, jangada e barco a vela. Os dois primeiros modelos usam motor, os dois
    seguintes são movimentados a remos e o último à vela. Usando o padrão strategy crie e
    implemente um modelo de classes que, dado um determinado barco, informe como ele está se
    movimentando.
    */
    public static void main(String... args) {

        Embarcacao jangada = new Jangada();
        System.out.println(jangada.getMovimentationMode().getValue());

    }
}
