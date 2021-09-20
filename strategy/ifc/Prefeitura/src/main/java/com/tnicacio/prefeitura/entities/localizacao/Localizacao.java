package com.tnicacio.prefeitura.entities.localizacao;

public class Localizacao {

    private char sigla;
    private float valorM2;
    private float valorFixo;

    public Localizacao(char sigla, float valorM2, float valorFixo) {
        this.sigla = sigla;
        this.valorM2 = valorM2;
        this.valorFixo = valorFixo;
    }

    public char getSigla() {
        return sigla;
    }

    public void setSigla(char sigla) {
        this.sigla = sigla;
    }

    public float getValorM2() {
        return valorM2;
    }

    public void setValorM2(float valorM2) {
        this.valorM2 = valorM2;
    }

    public float getValorFixo() {
        return valorFixo;
    }

    public void setValorFixo(float valorFixo) {
        this.valorFixo = valorFixo;
    }

}
