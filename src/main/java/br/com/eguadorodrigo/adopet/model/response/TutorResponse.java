package br.com.eguadorodrigo.adopet.model.response;

import br.com.eguadorodrigo.adopet.model.entities.Tutor;

public class TutorResponse extends CustomBaseResponse<Tutor>{

    public TutorResponse(String message, String apiCode) {
        super(message, apiCode);
    }
}
