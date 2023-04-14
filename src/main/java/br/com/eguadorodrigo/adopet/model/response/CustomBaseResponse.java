package br.com.eguadorodrigo.adopet.model.response;

import java.util.List;

public abstract class CustomBaseResponse<T>{

    private String apiCode;
    private String message;
    private T entity;
    private List<T> entities;

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

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }
}
