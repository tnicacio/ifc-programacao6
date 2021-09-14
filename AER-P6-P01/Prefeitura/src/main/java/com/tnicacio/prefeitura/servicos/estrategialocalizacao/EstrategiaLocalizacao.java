package com.tnicacio.prefeitura.servicos.estrategialocalizacao;

import com.tnicacio.prefeitura.entities.imovel.Imovel;

public interface EstrategiaLocalizacao {

    Imovel getImovel();

    float getValorPorM2();

    float getValorFixoTerreno();

    default float calcularValor() {
        return (getImovel().getEspaco() * getValorPorM2()) + getValorFixoTerreno();
    };

}
