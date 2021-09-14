package com.tnicacio.prefeitura.entities.enums;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.servicos.estrategialocalizacao.EstrategiaLocalizacao;
import com.tnicacio.prefeitura.servicos.estrategialocalizacao.EstrategiaLocalizacaoAImpl;
import com.tnicacio.prefeitura.servicos.estrategialocalizacao.EstrategiaLocalizacaoBImpl;
import com.tnicacio.prefeitura.servicos.estrategialocalizacao.EstrategiaLocalizacaoCImpl;

public enum Localizacao {

    A('A') {
        @Override
        public float calcularValor(Imovel imovel) {
            return new EstrategiaLocalizacaoAImpl(imovel).calcularValor();
        }
    },
    B('B') {
        @Override
        public float calcularValor(Imovel imovel) {
            return new EstrategiaLocalizacaoBImpl(imovel).calcularValor();
        }
    }, C('C') {
        @Override
        public float calcularValor(Imovel imovel) {
            return new EstrategiaLocalizacaoCImpl(imovel).calcularValor();
        }
    };

    private char localizacao;
    private EstrategiaLocalizacao estrategia;

    Localizacao(char localizacao) {
        this.localizacao = localizacao;
    }

    public abstract float calcularValor(Imovel imovel);
}
