package com.tnicacio.prefeitura;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.imovel.impl.Casa;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComEdificacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComportamento;

public class PrefeituraApplication {

    public static void main(String[] args) {

        Localizacao localizacaoA = new Localizacao('A', 3000, 1500);
        Localizacao localizacaoB = new Localizacao('B', 1000, 750);
        Localizacao localizacaoC = new Localizacao('C', 500, 200);

        Imovel casa = new Casa(localizacaoA, 10, 2);
        System.out.println(casa.calcularValor());

        DefinirValorComportamento estrategia = new DefinirValorComEdificacao();
        float valor = estrategia.definirValor(null);

        System.out.println(valor);
    }
}
