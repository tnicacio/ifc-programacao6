package com.tnicacio.prefeitura.entities.imovel.impl;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.enums.Localizacao;
import com.tnicacio.prefeitura.servicos.definirvalorcomportamento.DefinirValorComEdificacao;

public class Casa extends Imovel {

    public Casa(Localizacao localizacao, float espaco, int comodos) {
        super(localizacao, espaco, comodos);
        setDefinirValorComportamento(new DefinirValorComEdificacao(this));
    }

}
