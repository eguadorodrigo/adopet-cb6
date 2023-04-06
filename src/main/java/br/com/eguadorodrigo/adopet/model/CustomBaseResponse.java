package br.com.eguadorodrigo.adopet.model;

import java.util.List;

public abstract class CustomBaseResponse<T>{

    private String apiCode;
    private String message;
    private T entidade;
    private List<T> entidades;

    public CustomBaseResponse(String apiCode, String message) {
        this.apiCode = apiCode;
        this.message = message;
    }

    public CustomBaseResponse() {
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }

    public List<T> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<T> entidades) {
        this.entidades = entidades;
    }
}
