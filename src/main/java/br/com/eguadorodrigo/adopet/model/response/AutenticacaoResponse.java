package br.com.eguadorodrigo.adopet.model.response;

public class AutenticacaoResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AutenticacaoResponse(String token) {
        this.token = token;
    }
}
