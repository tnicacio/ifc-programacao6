package com.tnicacio.prefeitura.services.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;


public class DefinirValorComEdificacao implements DefinirValorComportamento {

    @Override
    public float definirValor(Imovel imovel) {
        float valorDependenteDaLocalizacaoDoImovel = imovel.getLocalizacao().getValorFixo() +
                (imovel.getEspaco() * imovel.getLocalizacao().getValorM2());
        float valorDependenteDoNumeroDeComodosDoImovel = (imovel.getComodos() * 1000);
        return valorDependenteDaLocalizacaoDoImovel + valorDependenteDoNumeroDeComodosDoImovel;
    }

}
