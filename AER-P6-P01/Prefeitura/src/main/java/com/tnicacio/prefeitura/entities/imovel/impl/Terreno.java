package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorSemEdificacao;

public class Terreno extends Imovel {

    public Terreno(Localizacao localizacao, float espaco, int comodos) {
        super(localizacao, espaco, comodos);
        setDefinirValorComportamento(new DefinirValorSemEdificacao());
    }

}
