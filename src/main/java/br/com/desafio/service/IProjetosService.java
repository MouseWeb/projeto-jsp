package br.com.desafio.service;

import br.com.desafio.dto.ProjetoDto;
import br.com.desafio.model.Projeto;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IProjetosService {

    List<Projeto> listarProjetos();
    void buscarProjetoById(Long id, ModelMap model);
    Optional<Projeto> buscarProjetoById(Long id);
    String adicionarProjeto(ProjetoDto projeto, BindingResult result);
    void deletarProjetos(Long id);
    String atualizarProjeto(Long id, ProjetoDto projeto);
}
