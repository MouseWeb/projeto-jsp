package br.com.desafio.service.impl;

import br.com.desafio.dto.ProjetoDto;
import br.com.desafio.enums.CargoEnum;
import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.model.Membro;
import br.com.desafio.model.Pessoa;
import br.com.desafio.model.Projeto;
import br.com.desafio.repository.ProjetosRepository;
import br.com.desafio.service.IMembrosService;
import br.com.desafio.service.IPessoaService;
import br.com.desafio.service.IProjetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ProjetosServiceImpl implements IProjetosService {

    private final ProjetosRepository projetosRepository;
    private final IPessoaService pessoaService;
    private final IMembrosService membrosService;

    @Autowired
    public ProjetosServiceImpl(ProjetosRepository projetosRepository, IPessoaService pessoaService, IMembrosService membrosService) {
        this.projetosRepository = projetosRepository;
        this.pessoaService = pessoaService;
        this.membrosService = membrosService;
    }

    @Override
    public List<Projeto> listarProjetos() {
        return projetosRepository.findAll();
    }

    @Override
    public void buscarProjetoById(Long id, ModelMap model) {
        Projeto projeto = projetosRepository.findById(id).get();
        model.put("projetos", projeto);
    }

    @Override
    public Optional<Projeto> buscarProjetoById(Long id) {
        return projetosRepository.findById(id);
    }

    @Override
    public void deletarProjetos(Long id) {
        membrosService.deletarMembro(id + 35);
        projetosRepository.deleteById(id);
    }

    @Override
    public String atualizarProjeto(Long id, ProjetoDto projeto) {
        Optional<Projeto> projetoOptional = buscarProjetoById(id);

        if (projetoOptional.isPresent()) {
            Projeto projetoEntity = projetoOptional.get();
            projetoEntity.setNome(projeto.nome());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataInicio = LocalDate.parse(projeto.dataInicio(), formatter);
            LocalDate dataPrevisaoFim = LocalDate.parse(projeto.dataPrevisaoFim(), formatter);
            LocalDate dataFim = LocalDate.parse(projeto.dataFim(), formatter);

            projetoEntity.setDataInicio(dataInicio);
            projetoEntity.setDataPrevisaoFim(dataPrevisaoFim);
            projetoEntity.setDataFim(dataFim);

            projetoEntity.setDescricao(projeto.descricao());
            projetoEntity.setOrcamento(projeto.orcamento());
            projetoEntity.setStatus(projeto.status());
            projetoEntity.setRisco(projeto.risco());

            projetosRepository.save(projetoEntity);

            return RedirectEnum.REDIRECT_LISTAR_PROJETOS.getValor();
        } else {
            return ResponseEntity.notFound().build().toString();
        }
    }

    @Override
    public String adicionarProjeto(ProjetoDto projeto, BindingResult result) {
        if (result.hasErrors()) {
            return RedirectEnum.REDIRECT_ADICIONAR_PROJETOS.getValor();
        } else if (projeto.nome() == null) {
            if (pessoaService.listarPessoas().isEmpty()) {
                ModelMap m = new ModelMap();
                m.put("alerta", "Necessário salvar um funcionário, primeiro.");
                return RedirectEnum.REDIRECT_LISTAR_PESSOAS.getValor();
            }
            return RedirectEnum.REDIRECT_ADICIONAR_PROJETOS.getValor();
        } else {
            long lastId = listarProjetos().size();
            Projeto projetoEntity = new Projeto();
            if (lastId != 0) {
                Projeto projId = listarProjetos().get(listarProjetos().size() - 1);
                projetoEntity.setId(projId.getId() + 1);
            } else {
                projetoEntity.setId(lastId);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataInicio = LocalDate.parse(projeto.dataInicio(), formatter);
            LocalDate dataPrevisaoFim = LocalDate.parse(projeto.dataPrevisaoFim(), formatter);
            LocalDate dataFim = LocalDate.parse(projeto.dataFim(), formatter);

            projetoEntity.setDataInicio(dataInicio);
            projetoEntity.setDataPrevisaoFim(dataPrevisaoFim);
            projetoEntity.setDataFim(dataFim);

            projetoEntity.setNome(projeto.nome());
            projetoEntity.setDescricao(projeto.descricao());
            projetoEntity.setOrcamento(projeto.orcamento());
            projetoEntity.setStatus(projeto.status());
            projetoEntity.setRisco(projeto.risco());
            projetoEntity.setIdGerente(27L);
            projetosRepository.save(projetoEntity);

            Membro membro = new Membro();
            long lastMemId = membrosService.listarMembros().size();
            if (lastMemId != 0) {
                Membro memId = membrosService.listarMembros().get(membrosService.listarMembros().size() - 1);
                membro.setId(memId.getId() + 1);
            } else {
                membro.setId(1L);
            }

            List<Projeto> projetos = listarProjetos();
            if (!projetos.isEmpty()) {
                Projeto projetoList = projetos.get(projetos.size() - 1);
                membro.setProjeto(projetoList);
            }

            List<Pessoa> pessoas = pessoaService.listarPessoas();
            boolean funcionarioTrue = pessoas.stream().anyMatch(Pessoa::getFuncionario);

            if (!pessoas.isEmpty() && funcionarioTrue) {
                membro.setPessoa(pessoaService.buscarPessoaById(27L).orElse(null));
            } else {
                ModelMap m = new ModelMap();
                m.addAttribute("alerta", "Necessário salvar uma pessoa com atributo funcionário = true");
                return RedirectEnum.REDIRECT_INDEX.getValor();
            }
            membrosService.salvarMembro(membro);
        }

        return RedirectEnum.REDIRECT_LISTAR_PROJETOS.getValor();
    }
}