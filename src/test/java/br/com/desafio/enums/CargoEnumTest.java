package br.com.desafio.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CargoEnumTest {

    @Test
    void testFuncionarioCargo() {
        CargoEnum cargo = CargoEnum.FUNCIONARIO;
        assertEquals(1L, cargo.getCargo());
    }

    @Test
    void testGerenteCargo() {
        CargoEnum cargo = CargoEnum.GERENTE;
        assertEquals(2L, cargo.getCargo());
    }
}