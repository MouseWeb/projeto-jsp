package br.com.desafio.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MembroTest {

    @Test
    void testEmptyConstructor() {
        Membro membro = new Membro();

        assertNull(membro.getId());
        assertNull(membro.getNome());
    }
}