package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {

    List<Pessoa> listarPessoas();
    Optional<Pessoa> buscarPessoaById(Long id);
    void atualizarPessoa(Pessoa pessoa);
    void deletarPessoa(Long id);
    String salvarPessoa(Pessoa pessoa, BindingResult result);
}
