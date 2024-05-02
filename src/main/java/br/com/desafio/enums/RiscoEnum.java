package br.com.desafio.enums;

public enum RiscoEnum {
    BAIXO(1L),
    MEDIO(2L),
    ALTO(3L);

    private final Long risco;

    RiscoEnum(Long risco) {
        this.risco = risco;
    }

    public Long getRisco() {
        return risco;
    }
}