package com.tnicacio.prefeitura.servicos.estrategialocalizacao;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public class EstrategiaLocalizacaoCImpl implements EstrategiaLocalizacao {

    private Imovel imovel;
    private final float VALOR_ESPACO_M2 = 500;
    private final float VALOR_FIXO_TERRENO = 200;

    public EstrategiaLocalizacaoCImpl(Imovel imovel) {
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
