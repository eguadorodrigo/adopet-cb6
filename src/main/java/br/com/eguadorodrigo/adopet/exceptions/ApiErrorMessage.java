package br.com.eguadorodrigo.adopet.exceptions;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiErrorMessage {

    private HttpStatus status;
    private List<String> erros;

    public ApiErrorMessage(HttpStatus status, List<String> erros) {
        this.status = status;
        this.erros = erros;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }
}
