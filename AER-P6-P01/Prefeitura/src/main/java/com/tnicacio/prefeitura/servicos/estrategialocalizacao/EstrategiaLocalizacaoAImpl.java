package com.tnicacio.prefeitura.servicos.estrategialocalizacao;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class EstrategiaLocalizacaoAImpl implements EstrategiaLocalizacao {

    private Imovel imovel;
    private final float VALOR_ESPACO_M2 = 3000;
    private final float VALOR_FIXO_TERRENO = 1500;

    public EstrategiaLocalizacaoAImpl(Imovel imovel) {
        this.imovel = imovel;
    }

    @Override
    public Imovel getImovel() {
        return imovel;
    }

    @Override
    public float getValorPorM2() {
        return VALOR_ESPACO_M2;
    }

    @Override
    public float getValorFixoTerreno() {
        return VALOR_FIXO_TERRENO;
    }
}
