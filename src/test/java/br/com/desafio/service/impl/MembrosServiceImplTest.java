package br.com.desafio.service.impl;

import br.com.desafio.model.Membro;
import br.com.desafio.repository.MembrosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

 class MembrosServiceImplTest {

    private MembrosServiceImpl membrosService;

    @Mock
    private MembrosRepository membrosRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        membrosService = new MembrosServiceImpl(membrosRepository);
    }

    @Test
    void testListarMembros() {
        // Mock do repositório
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(1L, "Membro 1"));
        membros.add(new Membro(2L, "Membro 2"));
        when(membrosRepository.findAll()).thenReturn(membros);

        // Chamada do serviço
        List<Membro> resultado = membrosService.listarMembros();

        // Verificação
        assertEquals(2, resultado.size());
    }

    @Test
    void testDeletarMembro() {
        // Mock do repositório
        Long membroId = 1L;
        Membro membro = new Membro(membroId, "Membro");
        when(membrosRepository.findById(membroId)).thenReturn(Optional.of(membro));

        // Chamada do serviço
        membrosService.deletarMembro(membroId);

        // Verificação
        verify(membrosRepository, times(1)).delete(membro);
    }

    @Test
    void testSalvarMembro() {
        // Mock do repositório
        Membro membro = new Membro(1L, "Membro");
        when(membrosRepository.save(any(Membro.class))).thenReturn(membro);

        // Chamada do serviço
        membrosService.salvarMembro(membro);

        // Verificação
        verify(membrosRepository, times(1)).save(membro);
    }
}