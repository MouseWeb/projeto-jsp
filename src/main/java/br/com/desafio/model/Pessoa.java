package br.com.desafio.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "PESSOA")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres")
    private String nome;

    @Column(nullable = false)
    @NotNull(message = "A data de nascimento é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    @Column(nullable = false, length = 14)
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato XXX.XXX.XXX-XX")
    private String cpf;

    @Column(nullable = false)
    @NotNull(message = "A informação de funcionário é obrigatória")
    private Boolean funcionario;

    @Column(nullable = false)
    @NotNull(message = "A informação de funcionário é obrigatória")
    private Boolean gerente;

    @Column(name = "pessoa_col", length = 45)
    @Size(max = 45, message = "O campo pessoaCol deve ter no máximo 45 caracteres")
    private String pessoaCol;
}
