package br.com.eguadorodrigo.adopet.model.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class CidadeRequest extends AbstractBaseRequest{

    @NotEmpty(message = "Campo nome não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo sigla não pode ser vazio")
    private String sigla;

    public CidadeRequest() {
    }

    public CidadeRequest(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
