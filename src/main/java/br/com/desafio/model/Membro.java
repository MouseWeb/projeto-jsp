package br.com.desafio.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "MEMBROS")
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projetos_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_membros_projetos_idx"))
    private Projeto projeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_membros_pessoa1_idx"))
    private Pessoa pessoa;

    public Membro(long l, String s) {
        // TODO document why this constructor is empty
    }

    public Membro() {

    }

    public String getNome() {
        return null;
    }
}
