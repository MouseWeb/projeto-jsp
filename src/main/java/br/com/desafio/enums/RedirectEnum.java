package br.com.desafio.enums;

import lombok.Getter;

@Getter
public enum RedirectEnum {

	// PESSOA
	REDIRECT_LISTAR_PESSOAS("redirect:/listar-pessoas"),
	REDIRECT_ATUALIZAR_PESSOA("atualizar-pessoa"),
	REDIRECT_ADICIONAR_PESSOA("adicionar-pessoa"),

	// PROJETO
	REDIRECT_LISTAR_PROJETOS("redirect:/listar-projetos"),
	REDIRECT_ADICIONAR_PROJETOS("adicionar-projetos"),
	REDIRECT_ATUALIZAR_PROJETO("atualizar-projetos"),

	// INDEX
	REDIRECT_INDEX("index");

	private final String valor;

	RedirectEnum(String valor) {
		this.valor = valor;
	}

}