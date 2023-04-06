package br.com.eguadorodrigo.adopet.model;

import br.com.eguadorodrigo.adopet.model.enums.CidadeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_abrigo", schema = "CB6")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 50, nullable = false)
    private String telefone;

    @Enumerated(EnumType.STRING)
    @Column(name = "cidade")
    private CidadeEnum cidade;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    public Abrigo(Long id, String nome, String telefone, CidadeEnum cidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.descricao = descricao;
    }

    public Abrigo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public CidadeEnum getCidade() {
        return cidade;
    }

    public void setCidade(CidadeEnum cidade) {
        this.cidade = cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
