package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.enums.localizacao.Localizacao;
import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.services.definirvalorcomportamento.DefinirValorComEdificacao;

public class Apartamento extends Imovel {

    public Apartamento(Localizacao localizacao, float espaco, int comodos) {
        super(localizacao, espaco, comodos);
        setDefinirValorComportamento(new DefinirValorComEdificacao(this));
    }

}
