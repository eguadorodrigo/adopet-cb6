package br.com.eguadorodrigo.adopet.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AbrigoRequest {

    private Long id;

    @NotEmpty(message = "O campo nome deve ser informado.")
    private String nome;

    @NotEmpty(message = "O campo telefone deve ser informado.")
    private String telefone;

    @NotNull(message = "O campo cidade é obrigatório")
    private Long cidadeId;

    @NotEmpty(message = "O campo descricao deve ser informado.")
    private String descricao;

    public AbrigoRequest() {
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

    public Long getCidadeId() {
        return cidadeId;
    }

    public void setCidadeId(Long cidadeId) {
        this.cidadeId = cidadeId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
