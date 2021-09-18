package com.tnicacio.prefeitura.entities.enums;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.imovel.impl.Apartamento;
import com.tnicacio.prefeitura.entities.imovel.impl.Casa;
import com.tnicacio.prefeitura.entities.imovel.impl.Terreno;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;

public enum TipoImovel {

    CASA {
        @Override
        public Imovel getClassImpl() {
            return new Casa(new Localizacao('Z', 0, 0), 0, 0);
        }
    },
    APTO {
        @Override
        public Imovel getClassImpl() {
            return new Apartamento(new Localizacao('Z', 0, 0), 0, 0);
        }
    },
    TERRENO {
        @Override
        public Imovel getClassImpl() {
            return new Terreno(new Localizacao('Z', 0, 0), 0, 0);
        }
    };

    public abstract Imovel getClassImpl();

}
