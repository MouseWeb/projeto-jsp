package br.com.desafio.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RiscoEnumTest {

    @Test
    void testRiscoBaixo() {
        RiscoEnum risco = RiscoEnum.BAIXO;
        assertEquals(1L, risco.getRisco());
    }

    @Test
    void testRiscoMedio() {
        RiscoEnum risco = RiscoEnum.MEDIO;
        assertEquals(2L, risco.getRisco());
    }

    @Test
    void testRiscoAlto() {
        RiscoEnum risco = RiscoEnum.ALTO;
        assertEquals(3L, risco.getRisco());
    }
}