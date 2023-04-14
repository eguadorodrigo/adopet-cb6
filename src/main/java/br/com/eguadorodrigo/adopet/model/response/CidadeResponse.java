package br.com.eguadorodrigo.adopet.model.response;

import br.com.eguadorodrigo.adopet.model.entities.Cidade;

import java.util.List;

import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_CADASTRAR_CIDADE_CHAVE;
import static br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais.SUCESSO_CADASTRAR_CIDADE_VALOR;

public class CidadeResponse extends CustomBaseResponse<Cidade>{

    public CidadeResponse(String message, Cidade entity, List<Cidade> entities) {
        switch (message){
            case SUCESSO_CADASTRAR_CIDADE_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_CADASTRAR_CIDADE_VALOR);
            }
        }
        setEntity(entity);
        setEntities(entities);
    }
}
