package com.tnicacio.prefeitura;

import com.tnicacio.prefeitura.entities.enums.Localizacao;
import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.imovel.impl.Casa;

public class PrefeituraApplication {

    public static void main(String[] args) {

        Imovel casa = new Casa(Localizacao.A, 10, 2);
        System.out.println(casa.calcularValor());
    }
}
