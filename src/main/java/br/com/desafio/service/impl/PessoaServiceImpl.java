package br.com.desafio.service.impl;

import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.model.Pessoa;
import br.com.desafio.repository.PessoaRepository;
import br.com.desafio.service.IPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements IPessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public void deletarPessoa(Long id) {
        pessoaRepository.findById(id).ifPresent(pessoaRepository::delete);
    }

    @Override
    public String salvarPessoa(Pessoa pessoa, BindingResult result) {
        if (result.hasErrors()) {
            return RedirectEnum.REDIRECT_INDEX.getValor();
        } else if (pessoa.getNome() == null) {
            return RedirectEnum.REDIRECT_ADICIONAR_PESSOA.getValor();
        } else {
            List<Pessoa> pessoas = listarPessoas();
            Long lastPessoaId = pessoas.isEmpty() ? 0L : pessoas.get(pessoas.size() - 1).getId();
            pessoa.setId(lastPessoaId + 1);
            pessoa.setPessoaCol(String.valueOf(pessoa.getId()));

            pessoaRepository.save(pessoa);

            return RedirectEnum.REDIRECT_LISTAR_PESSOAS.getValor();
        }
    }

    @Override
    public Optional<Pessoa> buscarPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public void atualizarPessoa(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}