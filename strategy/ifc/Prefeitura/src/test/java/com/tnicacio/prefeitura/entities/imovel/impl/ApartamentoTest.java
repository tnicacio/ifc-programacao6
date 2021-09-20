package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComEdificacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComportamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApartamentoTest {

    @Test
    void deveUtilizarAEstrategiaDefinirValorComEdificacao() {
        Imovel apartamento = new Apartamento(new Localizacao('Z', 1, 1), 1, 1);
        DefinirValorComportamento estrategiaComEdificacao = new DefinirValorComEdificacao();
        assertEquals(estrategiaComEdificacao.definirValor(apartamento), apartamento.calcularValor());
    }

}