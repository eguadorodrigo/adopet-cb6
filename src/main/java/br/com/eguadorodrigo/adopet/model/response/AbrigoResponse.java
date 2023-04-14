package br.com.eguadorodrigo.adopet.model.response;

import br.com.eguadorodrigo.adopet.model.entities.Abrigo;

public class AbrigoResponse extends CustomBaseResponse<Abrigo>{

    public AbrigoResponse(String message, String apiCode) {
        super(message, apiCode);
    }

    public AbrigoResponse() {
        super();
    }
}
