package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComportamento;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorSemEdificacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerrenoTest {

    @Test
    void deveUtilizarAEstrategiaDefinirValorSemEdificacao() {
        Imovel terreno = new Terreno(new Localizacao('Z', 1, 1), 1, 1);
        DefinirValorComportamento estrategiaSemEdificacao = new DefinirValorSemEdificacao();
        assertEquals(estrategiaSemEdificacao.definirValor(terreno), terreno.calcularValor());
    }

}