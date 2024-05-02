package br.com.desafio.enums;

public enum CargoEnum {
    FUNCIONARIO(1L),
    GERENTE(2L);

    private final Long cargo;

    CargoEnum(Long cargo) {
        this.cargo = cargo;
    }

    public Long getCargo() {
        return cargo;
    }
}