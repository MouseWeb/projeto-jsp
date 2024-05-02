package br.com.desafio.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SessionEnumTest {

    @Test
    void testPessoaModel() {
        SessionEnum session = SessionEnum.PESSOA_MODEL;
        assertEquals("pessoa", session.getValor());
    }

    @Test
    void testProjetosModel() {
        SessionEnum session = SessionEnum.PROJETOS_MODEL;
        assertEquals("projetos", session.getValor());
    }
}