package br.com.desafio.enums;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RedirectEnumTest {

    @Test
    void testRedirectListarPessoas() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_LISTAR_PESSOAS;
        assertEquals("redirect:/listar-pessoas", redirect.getValor());
    }

    @Test
    void testRedirectAtualizarPessoa() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_ATUALIZAR_PESSOA;
        assertEquals("atualizar-pessoa", redirect.getValor());
    }

    @Test
    void testRedirectAdicionarPessoa() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_ADICIONAR_PESSOA;
        assertEquals("adicionar-pessoa", redirect.getValor());
    }

    @Test
    void testRedirectListarProjetos() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_LISTAR_PROJETOS;
        assertEquals("redirect:/listar-projetos", redirect.getValor());
    }

    @Test
    void testRedirectAdicionarProjetos() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_ADICIONAR_PROJETOS;
        assertEquals("adicionar-projetos", redirect.getValor());
    }

    @Test
    void testRedirectAtualizarProjeto() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_ATUALIZAR_PROJETO;
        assertEquals("atualizar-projetos", redirect.getValor());
    }

    @Test
    void testRedirectIndex() {
        RedirectEnum redirect = RedirectEnum.REDIRECT_INDEX;
        assertEquals("index", redirect.getValor());
    }
}