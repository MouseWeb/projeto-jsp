package br.com.desafio.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public record ProjetoDto(
        Long id,
        @Size(max = 200) String nome,
        @NotNull String dataInicio,
        @NotNull String dataPrevisaoFim,
        @NotNull String dataFim,
        String descricao,
        @Size(max = 25) String status,
        @NotNull BigDecimal orcamento,
        @Size(max = 25) String risco,
        Long idGerente
) { }