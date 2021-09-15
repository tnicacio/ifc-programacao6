package com.tnicacio.prefeitura.services.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class DefinirValorSemEdificacao implements  DefinirValorComportamento {

    private Imovel imovel;

    public DefinirValorSemEdificacao(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public float definirValor() {
        return imovel.getLocalizacao().valorFixo() +
                (imovel.getEspaco() * imovel.getLocalizacao().valorM2());
    }

}
