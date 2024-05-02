package br.com.desafio.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "PROJETO")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;


    @Size(max = 200)
    @Column(nullable = false, length = 200)
    private String nome;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataInicio;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataPrevisaoFim;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataFim;

    @Column(columnDefinition = "LONGTEXT", nullable = false, length = 5000)
    private String descricao;

    @Size(max = 25)
    @Column(nullable = false, length = 25)
    private String status;

    @NotNull
    @Column(nullable = false)
    private BigDecimal orcamento;

    @Size(max = 25)
    @Column(nullable = false, length = 25)
    private String risco;

    @Column(name = "idgerente")
    private Long idGerente;

    public Projeto(long l, String s) {
        // TODO document why this constructor is empty
    }

    public Projeto() {

    }

}