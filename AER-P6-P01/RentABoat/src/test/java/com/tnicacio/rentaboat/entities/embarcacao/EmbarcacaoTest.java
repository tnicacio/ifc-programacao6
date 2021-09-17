package com.tnicacio.rentaboat.entities.embarcacao;

import com.tnicacio.rentaboat.entities.enums.MovimentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmbarcacaoTest {

    private EmbarcacaoImplTest embarcacaoImplTest;

    @BeforeEach
    public void setUp() {
        embarcacaoImplTest = new EmbarcacaoImplTest();
    }

    @Test
    public void getMovimentationModeShouldReturnStrategyMovimentationModeDefinedOnEmbarcacaoImplCreation() {
        assertEquals(MovimentationType.MOTOR, embarcacaoImplTest.getMovimentationMode());
    }

    @Test
    public void getMovimentationModeShouldReturnNewStrategyMovimentationModeWhenEmbarcacaoImplChangedStrategy() {
        embarcacaoImplTest.setMovimentationStrategy(() -> MovimentationType.VELA);
        assertEquals(MovimentationType.VELA, embarcacaoImplTest.getMovimentationMode());
    }

    @Test
    public void getMovimentationModeShoulThrowNullPointerExceptionWhenStrategyIsNotDefined() {
        embarcacaoImplTest.setMovimentationStrategy(null);
        assertThrows(NullPointerException.class, () -> embarcacaoImplTest.getMovimentationMode());
    }

    private static class EmbarcacaoImplTest extends Embarcacao {
        public EmbarcacaoImplTest() {
            setMovimentationStrategy(() -> MovimentationType.MOTOR);
        }
    }

}