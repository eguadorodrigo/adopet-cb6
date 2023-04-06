package br.com.eguadorodrigo.adopet.model;

import br.com.eguadorodrigo.adopet.model.enums.CidadeEnum;

public class AbrigoRequest {

    private String nome;

    private String telefone;

    private CidadeEnum cidade;

    private String descricao;

    public AbrigoRequest(String nome, String telefone, CidadeEnum cidade, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.cidade = cidade;
        this.descricao = descricao;
    }

    public AbrigoRequest() {
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
