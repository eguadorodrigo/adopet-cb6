package br.com.eguadorodrigo.adopet.model.response;

import br.com.eguadorodrigo.adopet.model.entities.Adocao;

import java.util.List;


import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_CADASTRAR_ADOCAO_CHAVE;
import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_CADASTRAR_ADOCAO_VALOR;
import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_LISTAR_ADOCAO_CHAVE;
import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_LISTAR_ADOCAO_VALOR;

public class AdocaoResponse extends CustomBaseResponse<Adocao>{
    public AdocaoResponse(String message, Adocao entity, List<Adocao> entities) {
        switch (message){
            case SUCESSO_LISTAR_ADOCAO_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_LISTAR_ADOCAO_VALOR);
            }
            case SUCESSO_CADASTRAR_ADOCAO_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_CADASTRAR_ADOCAO_VALOR);
            }
        }
        setEntity(entity);
        setEntities(entities);
    }
}