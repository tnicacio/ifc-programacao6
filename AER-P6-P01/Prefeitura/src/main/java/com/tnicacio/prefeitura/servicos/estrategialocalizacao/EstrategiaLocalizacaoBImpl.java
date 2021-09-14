package com.tnicacio.prefeitura.servicos.estrategialocalizacao;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class EstrategiaLocalizacaoBImpl implements EstrategiaLocalizacao {

    private Imovel imovel;
    private final float VALOR_ESPACO_M2 = 1000;
    private final float VALOR_FIXO_TERRENO = 750;

    public EstrategiaLocalizacaoBImpl(Imovel imovel) {
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
