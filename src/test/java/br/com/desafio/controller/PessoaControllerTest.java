package br.com.desafio.controller;

import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.enums.SessionEnum;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.IPessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PessoaControllerTest {

    @Mock
    private IPessoaService pessoaService;

    @InjectMocks
    private PessoaController pessoaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarPessoas() {
        // Arrange
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        when(pessoaService.listarPessoas()).thenReturn(pessoas);
        ModelMap model = new ModelMap();

        // Act
        String viewName = pessoaController.listarPessoas(model);

        // Assert
        assertEquals(SessionEnum.PESSOA_MODEL.getValor(), viewName);
        assertEquals(pessoas, model.get("pessoa"));
        verify(pessoaService, times(1)).listarPessoas();
    }

    @Test
    void testDeletarPessoa() {
        // Arrange
        Long id = 1L;

        // Act
        String redirectUrl = pessoaController.deletarPessoa(id);

        // Assert
        assertEquals(RedirectEnum.REDIRECT_LISTAR_PESSOAS.getValor(), redirectUrl);
        verify(pessoaService, times(1)).deletarPessoa(id);
    }

    @Test
    void testAdicionarPessoa() {
        // Arrange
        Pessoa pessoa = new Pessoa();
        BindingResult result = mock(BindingResult.class);

        when(pessoaService.salvarPessoa(pessoa, result)).thenReturn("success");

        // Act
        String viewName = pessoaController.adicionarPessoa(pessoa, result);

        // Assert
        assertEquals("success", viewName);
        verify(pessoaService, times(1)).salvarPessoa(pessoa, result);
    }

    @Test
    void testAtualizarPessoa() {
        // Arrange
        Pessoa pessoa = new Pessoa();
        BindingResult result = mock(BindingResult.class);

        when(pessoaService.salvarPessoa(pessoa, result)).thenReturn("success");

        // Act
        String viewName = pessoaController.atualizarPessoa(pessoa, result);

        // Assert
        assertEquals("success", viewName);
        verify(pessoaService, times(1)).salvarPessoa(pessoa, result);
    }

    @Test
    void testRedirect() {
        // Arrange
        ModelMap model = new ModelMap();

        // Act
        String viewName = pessoaController.redirect(model);

        // Assert
        assertEquals(SessionEnum.PESSOA_MODEL.getValor(), viewName);
        assertEquals("Necessário salvar um funcionário primeiro.", model.get("alerta"));
        verify(pessoaService, times(1)).listarPessoas();
    }
}