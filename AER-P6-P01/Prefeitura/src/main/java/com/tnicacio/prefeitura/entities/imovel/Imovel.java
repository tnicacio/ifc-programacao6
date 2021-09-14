package com.tnicacio.prefeitura.entities.imovel;

import com.tnicacio.prefeitura.entities.enums.Localizacao;
import com.tnicacio.prefeitura.servicos.definirvalorcomportamento.DefinirValorComportamento;

public abstract class Imovel {

    private int comodos;
    private float espaco;
    private Localizacao localizacao;
    private DefinirValorComportamento valor;

    public Imovel(Localizacao localizacao, float espaco, int comodos) {
        this.localizacao = localizacao;
        this.espaco = espaco;
        this.comodos = comodos;
    }

    public void setDefinirValorComportamento(DefinirValorComportamento valor) {
        this.valor = valor;
    }

    public int getComodos() {
        return comodos;
    }

    public void setComodos(int comodos) {
        this.comodos = comodos;
    }

    public float getEspaco() {
        return espaco;
    }

    public void setEspaco(float espaco) {
        this.espaco = espaco;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public float calcularValor() {
        return valor.definirValor();
    }

}
