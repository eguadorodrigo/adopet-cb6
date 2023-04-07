package br.com.eguadorodrigo.adopet.model;

import br.com.eguadorodrigo.adopet.model.enums.CidadeEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AbrigoRequest {

    private Long id;

    @NotEmpty(message = "O campo nome deve ser informado.")
    private String nome;

    @NotEmpty(message = "O campo telefone deve ser informado.")
    private String telefone;

    @NotNull
    private CidadeEnum cidade;

    @NotEmpty(message = "O campo descricao deve ser informado.")
    private String descricao;

    public AbrigoRequest(Long id, String nome, String telefone, CidadeEnum cidade, String descricao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.descricao = descricao;
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
