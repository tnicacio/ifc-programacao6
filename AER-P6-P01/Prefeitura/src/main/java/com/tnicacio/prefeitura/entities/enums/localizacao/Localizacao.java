package com.tnicacio.prefeitura.entities.enums.localizacao;

public enum Localizacao implements LocalTributavel {

    A('A') {
        @Override
        public float valorM2() {
            return 3000;
        }

        @Override
        public float valorFixo() {
            return 1500;
        }
    },
    B('B') {
        @Override
        public float valorM2() {
            return 1000;
        }

        @Override
        public float valorFixo() {
            return 750;
        }
    }, C('C') {
        @Override
        public float valorM2() {
            return 500;
        }

        @Override
        public float valorFixo() {
            return 200;
        }
    };

    private char localizacao;

    Localizacao(char localizacao) {
        this.localizacao = localizacao;
    }

}
