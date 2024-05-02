package br.com.desafio.service.impl;

import br.com.desafio.dto.ProjetoDto;
import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projeto;
import br.com.desafio.repository.ProjetosRepository;
import br.com.desafio.service.IMembrosService;
import br.com.desafio.service.IPessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjetosServiceImplTest {

    @Mock
    private ProjetosRepository projetosRepository;

    @Mock
    private IPessoaService pessoaService;

    @Mock
    private IMembrosService membrosService;

    @InjectMocks
    private ProjetosServiceImpl projetosService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        projetos.add(new Projeto());
        projetos.add(new Projeto());
        projetos.add(new Projeto());

        when(projetosRepository.findAll()).thenReturn(projetos);

        assertEquals(3, projetosService.listarProjetos().size());
    }

    @Test
    public void testBuscarProjetoById() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setNome("Projeto de Teste");

        when(projetosRepository.findById(1L)).thenReturn(Optional.of(projeto));

        ModelMap model = new ModelMap();
        projetosService.buscarProjetoById(1L, model);

        assertEquals("Projeto de Teste", ((Projeto) model.get("projetos")).getNome());
    }

    @Test
    public void testDeletarProjetos() {
        Long id = 10L;
        projetosService.deletarProjetos(id);
        verify(membrosService).deletarMembro(id + 35);
        verify(projetosRepository).deleteById(id);
    }

    @Test
    public void testAtualizarProjeto() {
        ProjetoDto projetoDto = new ProjetoDto(
                1L,
                "Projeto de Teste",
                "2024-04-20",
                "2024-05-20",
                "2024-06-20",
                "Descrição do Projeto de Teste",
                BigDecimal.valueOf(1000).toString(),
                BigDecimal.valueOf(1L),
                BigDecimal.valueOf(1).toString(),
                null
        );
    }

    @Test
    public void testAdicionarProjeto_WithEmptyPessoaList() {
        ProjetoDto projetoDto = new ProjetoDto(
                null,
                "Projeto de Teste",
                "2024-04-20",
                "2024-05-20",
                "2024-06-20",
                "Descrição do Projeto de Teste",
                BigDecimal.valueOf(1000).toString(),
                BigDecimal.valueOf(1L),
                BigDecimal.valueOf(1).toString(),
                null
        );

        when(projetosRepository.findAll()).thenReturn(new ArrayList<>());
        when(pessoaService.listarPessoas()).thenReturn(new ArrayList<>());

        verifyNoMoreInteractions(membrosService);
    }

}
