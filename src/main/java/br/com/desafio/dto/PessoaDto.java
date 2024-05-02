package br.com.desafio.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import java.time.LocalDate;

public record PessoaDto(
        @Column(name = "id", updatable = false, nullable = false) Long id,
        @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres") String nome,
        @NotNull(message = "A data de nascimento é obrigatória") LocalDate dataNascimento,
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato XXX.XXX.XXX-XX") String cpf,
        @NotNull(message = "A informação de funcionário é obrigatória") Boolean funcionario,
        @NotNull(message = "A informação de funcionário é obrigatória") Boolean gerente,
        String pessoaCol
) {}
