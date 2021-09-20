package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComEdificacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComportamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CasaTest {

    @Test
    void deveUtilizarAEstrategiaDefinirValorComEdificacao() {
        Imovel casa = new Casa(new Localizacao('Z', 1, 1), 1, 1);
        DefinirValorComportamento estrategiaComEdificacao = new DefinirValorComEdificacao();
        assertEquals(estrategiaComEdificacao.definirValor(casa), casa.calcularValor());
    }

}