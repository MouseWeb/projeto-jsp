package br.com.desafio.controller;

import br.com.desafio.dto.ProjetoDto;
import br.com.desafio.enums.RedirectEnum;
import br.com.desafio.enums.SessionEnum;
import br.com.desafio.model.Projeto;
import br.com.desafio.service.IProjetosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Api(tags = "Projeto Controller")
public class ProjetoController {

    @Autowired
    private IProjetosService projetosService;

    @GetMapping("/listar-projetos")
    @ApiOperation("Exibe a lista de projetos")
    public String listarProjetos(ModelMap model) {
        model.put("projeto", projetosService.listarProjetos());
        return SessionEnum.PROJETOS_MODEL.getValor();
    }

    @GetMapping("/deletar-projeto/{id}")
    @ApiOperation("Exclui um projeto")
    public String deletarProjeto(@PathVariable("id") Long id) {
        projetosService.deletarProjetos(id);
        return RedirectEnum.REDIRECT_LISTAR_PROJETOS.getValor();
    }

    @GetMapping("/atualizar-projeto/{id}")
    @ApiOperation("Exibe a página de atualização de um projeto")
    public String exibirAtualizarProjeto(@PathVariable("id") Long id, ModelMap model) {
        Projeto projeto = projetosService.buscarProjetoById(id).orElse(null);
        model.addAttribute("projeto", projeto);
        return RedirectEnum.REDIRECT_ATUALIZAR_PROJETO.getValor();
    }

    @PostMapping("/atualizar-projeto/{id}")
    @ApiOperation("Atualiza um projeto")
    public String atualizarProjeto(@PathVariable("id") Long id, ProjetoDto projeto) {
        return projetosService.atualizarProjeto(id, projeto);
    }

    @PostMapping("/adicionar-projeto")
    @ApiOperation("Adiciona um novo projeto")
    public String adicionarProjeto(ProjetoDto projeto, BindingResult result) {
        return projetosService.adicionarProjeto(projeto, result);
    }

}