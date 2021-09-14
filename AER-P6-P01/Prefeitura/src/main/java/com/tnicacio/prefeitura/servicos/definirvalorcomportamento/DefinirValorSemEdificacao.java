package com.tnicacio.prefeitura.servicos.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class DefinirValorSemEdificacao implements  DefinirValorComportamento {

    private Imovel imovel;

    public DefinirValorSemEdificacao(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public float definirValor() {
        return imovel.getLocalizacao().calcularValor(imovel);
    }

}
