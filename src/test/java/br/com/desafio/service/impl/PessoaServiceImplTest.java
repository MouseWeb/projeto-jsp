package br.com.desafio.service.impl;
import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.model.Pessoa;
import br.com.desafio.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PessoaServiceImplTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaServiceImpl pessoaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarPessoas() {
        // Arrange
        List<Pessoa> pessoas = new ArrayList<>();
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        // Act
        List<Pessoa> result = pessoaService.listarPessoas();

        // Assert
        assertEquals(pessoas, result);
        verify(pessoaRepository, times(1)).findAll();
    }

    @Test
    void testDeletarPessoa() {
        // Arrange
        Long id = 1L;

        // Act
        pessoaService.deletarPessoa(id);

        // Assert
        verify(pessoaRepository, times(1)).findById(id);
    }

    @Test
    void testSalvarPessoa_WithValidationErrors() {
        // Arrange
        Pessoa pessoa = new Pessoa();
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(true);

        // Act
        String redirectUrl = pessoaService.salvarPessoa(pessoa, result);

        // Assert
        assertEquals(RedirectEnum.REDIRECT_INDEX.getValor(), redirectUrl);
        verify(result, times(1)).hasErrors();
        verify(pessoaRepository, never()).save(any(Pessoa.class));
    }

    @Test
    void testSalvarPessoa_WithEmptyName() {
        // Arrange
        Pessoa pessoa = new Pessoa();
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        pessoa.setNome(null);

        // Act
        String redirectUrl = pessoaService.salvarPessoa(pessoa, result);

        // Assert
        assertEquals(RedirectEnum.REDIRECT_ADICIONAR_PESSOA.getValor(), redirectUrl);
        verify(result, times(1)).hasErrors();
        verify(pessoaRepository, never()).save(any(Pessoa.class));
    }

    @Test
    void testSalvarPessoa_Success() {
        // Arrange
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("John Doe");
        BindingResult result = mock(BindingResult.class);
        when(result.hasErrors()).thenReturn(false);
        when(pessoaRepository.findAll()).thenReturn(pessoas);

        // Act
        String redirectUrl = pessoaService.salvarPessoa(pessoa, result);

        // Assert
        assertEquals(RedirectEnum.REDIRECT_LISTAR_PESSOAS.getValor(), redirectUrl);
        assertEquals(1L, pessoa.getId());
        assertEquals("1", pessoa.getPessoaCol());
        verify(result, times(1)).hasErrors();
        verify(pessoaRepository, times(1)).findAll();
        verify(pessoaRepository, times(1)).save(pessoa);
    }

    @Test
    void testBuscarPessoaById() {
        // Arrange
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.findById(id)).thenReturn(Optional.of(pessoa));

        // Act
        Optional<Pessoa> result = pessoaService.buscarPessoaById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(pessoa, result.get());
        verify(pessoaRepository, times(1)).findById(id);
    }

    @Test
    void testBuscarPessoaById_NotFound() {
        // Arrange
        Long id = 1L;
        when(pessoaRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Optional<Pessoa> result = pessoaService.buscarPessoaById(id);

        // Assert
        assertFalse(result.isPresent());
        verify(pessoaRepository, times(1)).findById(id);
    }

    @Test
    void testAtualizarPessoa() {
        // Arrange
        Pessoa pessoa = new Pessoa();

        // Act
        pessoaService.atualizarPessoa(pessoa);

        // Assert
        verify(pessoaRepository, times(1)).save(pessoa);
    }
}