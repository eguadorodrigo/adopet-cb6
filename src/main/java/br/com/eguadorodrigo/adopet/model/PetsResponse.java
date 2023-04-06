package br.com.eguadorodrigo.adopet.model;

public class PetsResponse extends CustomBaseResponse<Pets>{
    public PetsResponse(String message, String apiCode) {
        super(message, apiCode);
    }
}
