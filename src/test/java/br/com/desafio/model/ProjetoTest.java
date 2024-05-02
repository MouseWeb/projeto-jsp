package br.com.desafio.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjetoTest {

    @Test
    void testSetAndGetId() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        assertEquals(1L, projeto.getId());
    }

    @Test
    void testSetAndGetNome() {
        Projeto projeto = new Projeto();
        projeto.setNome("Projeto Teste");
        assertEquals("Projeto Teste", projeto.getNome());
    }

    @Test
    void testSetAndGetDataInicio() {
        Projeto projeto = new Projeto();
        LocalDate dataInicio = LocalDate.of(2023, 5, 1);
        projeto.setDataInicio(dataInicio);
        assertEquals(dataInicio, projeto.getDataInicio());
    }

    @Test
    void testSetAndGetDataPrevisaoFim() {
        Projeto projeto = new Projeto();
        LocalDate dataPrevisaoFim = LocalDate.of(2023, 6, 30);
        projeto.setDataPrevisaoFim(dataPrevisaoFim);
        assertEquals(dataPrevisaoFim, projeto.getDataPrevisaoFim());
    }

    @Test
    void testSetAndGetDataFim() {
        Projeto projeto = new Projeto();
        LocalDate dataFim = LocalDate.of(2023, 7, 31);
        projeto.setDataFim(dataFim);
        assertEquals(dataFim, projeto.getDataFim());
    }

    @Test
    void testSetAndGetDescricao() {
        Projeto projeto = new Projeto();
        String descricao = "Descrição do projeto";
        projeto.setDescricao(descricao);
        assertEquals(descricao, projeto.getDescricao());
    }

    @Test
    void testSetAndGetStatus() {
        Projeto projeto = new Projeto();
        String status = "Em andamento";
        projeto.setStatus(status);
        assertEquals(status, projeto.getStatus());
    }

    @Test
    void testSetAndGetOrcamento() {
        Projeto projeto = new Projeto();
        BigDecimal orcamento = BigDecimal.valueOf(10000);
        projeto.setOrcamento(orcamento);
        assertEquals(orcamento, projeto.getOrcamento());
    }

    @Test
    void testSetAndGetRisco() {
        Projeto projeto = new Projeto();
        String risco = "Alto";
        projeto.setRisco(risco);
        assertEquals(risco, projeto.getRisco());
    }

    @Test
    void testSetAndGetIdGerente() {
        Projeto projeto = new Projeto();
        Long idGerente = 1L;
        projeto.setIdGerente(idGerente);
        assertEquals(idGerente, projeto.getIdGerente());
    }

    @Test
    void testDefaultConstructor() {
        Projeto projeto = new Projeto();
        assertNull(projeto.getId());
        assertNull(projeto.getNome());
    }
}