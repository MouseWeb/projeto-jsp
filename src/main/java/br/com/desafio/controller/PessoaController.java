package br.com.desafio.controller;

import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.enums.SessionEnum;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.IPessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "Pessoa Controller")
public class PessoaController {

    @Autowired
    private IPessoaService pessoaService;

    @GetMapping("/listar-pessoas")
    @ApiOperation("Exibe a lista de pessoas")
    public String listarPessoas(ModelMap model) {
        model.put("pessoa", pessoaService.listarPessoas());
        return SessionEnum.PESSOA_MODEL.getValor();
    }

    @GetMapping("/deletar-pessoa/{id}")
    @ApiOperation("Exclui uma pessoa")
    public String deletarPessoa(@PathVariable("id") Long id) {
        pessoaService.deletarPessoa(id);
        return RedirectEnum.REDIRECT_LISTAR_PESSOAS.getValor();
    }

    @PostMapping("/adicionar-pessoa")
    @ApiOperation("Adiciona uma nova pessoa")
    public String adicionarPessoa(Pessoa pessoa, BindingResult result) {
        return pessoaService.salvarPessoa(pessoa, result);
    }

    @PutMapping("/atualizar-pessoa")
    @ApiOperation("Atualiza dados de pessoa")
    public String atualizarPessoa(Pessoa pessoa, BindingResult result) {
        return pessoaService.salvarPessoa(pessoa, result);
    }

    @PostMapping("/buscar-pessoa/{id}")
    @ApiOperation("Buscar uma pessoa")
    public String buscarPessoa(@PathVariable("id") Long id, ModelMap model) {
        model.put("pessoa", pessoaService.buscarPessoaById(id));
        return RedirectEnum.REDIRECT_ATUALIZAR_PESSOA.getValor();
    }

    @GetMapping("/redirect")
    @ApiOperation("Redireciona para a página de pessoas")
    public String redirect(ModelMap model) {
        model.put("alerta", "Necessário salvar um funcionário primeiro.");
        return listarPessoas(model);
    }
}