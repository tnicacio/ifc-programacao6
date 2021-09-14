package com.tnicacio.prefeitura.servicos.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class DefinirValorComEdificacao implements  DefinirValorComportamento {

    private Imovel imovel;

    public DefinirValorComEdificacao(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public float definirValor() {
        return imovel.getLocalizacao().calcularValor(imovel) + (imovel.getComodos() * 1000);
    }

}
