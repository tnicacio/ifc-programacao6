package com.tnicacio.prefeitura.services.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class DefinirValorComEdificacao implements  DefinirValorComportamento {

    private Imovel imovel;

    public DefinirValorComEdificacao(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public float definirValor() {
        float valorDependenteDaLocalizacaoDoImovel = imovel.getLocalizacao().getValorFixo() +
                (imovel.getEspaco() * imovel.getLocalizacao().getValorM2());
        float valorDependenteDoNumeroDeComodosDoImovel = (imovel.getComodos() * 1000);
        return  valorDependenteDaLocalizacaoDoImovel + valorDependenteDoNumeroDeComodosDoImovel;
    }

}
