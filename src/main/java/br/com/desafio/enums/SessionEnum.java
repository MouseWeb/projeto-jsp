package br.com.desafio.enums;

public enum SessionEnum {
	PESSOA_MODEL("pessoa"),
	PROJETOS_MODEL("projetos");

	private final String valor;

	SessionEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
}