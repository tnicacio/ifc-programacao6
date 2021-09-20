package com.tnicacio.prefeitura;

import com.tnicacio.prefeitura.entities.enums.TipoImovel;
import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;

import java.util.List;
import java.util.Random;

public class PrefeituraApplication {

    public static void main(String[] args) {

        List<Localizacao> localizacoes = List.of(
                new Localizacao('A', 3000, 1500),
                new Localizacao('B', 1000, 750),
                new Localizacao('C', 500, 200));

        List<TipoImovel> tiposDeImoveis = List.of(TipoImovel.CASA, TipoImovel.APTO, TipoImovel.TERRENO);
        float espaco = (new Random().nextFloat() + 1) * 50;
        int comodos = new Random().nextInt(9) + 1;

        System.out.println("----- Valores Fixos ----- ");
        System.out.println("Espaço (m2): " + espaco);
        System.out.println("Número de cômodos: " + comodos + "\n");

        localizacoes.forEach(localizacao -> {
            System.out.println("----- Localização " + localizacao.getSigla() + " -----");
            System.out.println("Imovel ------- " + "\t" + "Valor");

            tiposDeImoveis.forEach(tipoImovel -> {
                Imovel imovel = tipoImovel.getClassImpl();
                imovel.setLocalizacao(localizacao);
                imovel.setEspaco(espaco);
                imovel.setComodos(comodos);

                System.out.println(tipoImovel + "\t\t\t" + imovel.calcularValor());
            });
        });
    }
}
