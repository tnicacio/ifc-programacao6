package com.tnicacio.prefeitura.services.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class DefinirValorSemEdificacao implements  DefinirValorComportamento {

    @Override
    public float definirValor(Imovel imovel) {
        return imovel.getLocalizacao().getValorFixo() +
                (imovel.getEspaco() * imovel.getLocalizacao().getValorM2());
    }

}
