package com.tnicacio.prefeitura.services.definirvalorcomportamento;

import com.tnicacio.prefeitura.entities.imovel.Imovel;
import com.tnicacio.prefeitura.entities.localizacao.Localizacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefinirValorSemEdificacaoTest {

    private DefinirValorSemEdificacao servico;
    private ImovelSemEdificacaoImplTest imovel;
    private Localizacao localizacao;

    @BeforeEach
    public void initialize() {
        servico = new DefinirValorSemEdificacao();
        localizacao = new Localizacao('A', 1000, 10000);
        imovel = new ImovelSemEdificacaoImplTest(localizacao, 100, 1);
    }

    @Test
    @DisplayName("valorDoImovel = localizacao.valorFixo + (localizacao.valorM2 * espaco)")
    public void deveRetornarOValorDependenteDaLocalizacao() {

        localizacao.setValorFixo(15000);
        localizacao.setValorM2(200);
        imovel.setLocalizacao(localizacao);
        imovel.setEspaco(100);
        imovel.setComodos(1);

        float valorDependenteDaLocalizacao = 15000 + (100 * 200); //35000

        float resultado = servico.definirValor(imovel);

        assertEquals(valorDependenteDaLocalizacao, resultado);
    }

    @Test
    @DisplayName("Quando os valores para o cálculo forem iguais a zero, o valor do imóvel deve ser igual a zero")
    public void deveRetornarZeroQuandoValorFixoEValorM2EEspacoComodosCadastradosForemIguaisAZero() {

        localizacao.setValorFixo(0);
        localizacao.setValorM2(0);
        imovel.setLocalizacao(localizacao);
        imovel.setEspaco(0);
        imovel.setComodos(0);

        assertEquals(0, servico.definirValor(imovel));
    }

    @Test
    @DisplayName("O Imóvel não pode ser nulo")
    public void deveLancarNullPointerExceptionQuandoNaoHouverImovel() {
        assertThrows(NullPointerException.class, () -> servico.definirValor(null));
    }

    @Test
    @DisplayName("A Localização nao pode ser nula")
    public void deveLancarNullPointerExceptionQuandoNaoHouverLocalizacaoNoImovel() {
        imovel.setLocalizacao(null);
        assertThrows(NullPointerException.class, () -> servico.definirValor(imovel));
    }

    private static class ImovelSemEdificacaoImplTest extends Imovel {
        public ImovelSemEdificacaoImplTest(Localizacao localizacao, float espaco, int comodos) {
            super(localizacao, espaco, comodos);
            setDefinirValorComportamento(new DefinirValorSemEdificacao());
        }
    }
}