package br.com.eguadorodrigo.adopet.model;

import java.util.List;

import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_ATUALIZAR_PET_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_ATUALIZAR_PET_PARCIAL_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_ATUALIZAR_PET_PARCIAL_VALOR;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_ATUALIZAR_PET_VALOR;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_BUSCAR_PETS_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_BUSCAR_PETS_VALOR;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_BUSCAR_PET_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_BUSCAR_PET_VALOR;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_CADASTRAR_PET_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_CADASTRAR_PET_VALOR;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_DELETAR_PET_CHAVE;
import static br.com.eguadorodrigo.adopet.model.ConstantesGlobais.SUCESSO_DELETAR_PET_VALOR;

public class PetResponse extends CustomBaseResponse<Pet>{
    public PetResponse(String message, Pet entity, List<Pet> entities) {
        switch (message){
            case SUCESSO_CADASTRAR_PET_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_CADASTRAR_PET_VALOR);
            }
            case SUCESSO_BUSCAR_PET_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_BUSCAR_PET_VALOR);
            }
            case SUCESSO_BUSCAR_PETS_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_BUSCAR_PETS_VALOR);
            }
            case SUCESSO_ATUALIZAR_PET_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_ATUALIZAR_PET_VALOR);
            }
            case SUCESSO_ATUALIZAR_PET_PARCIAL_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_ATUALIZAR_PET_PARCIAL_VALOR);
            }
            case SUCESSO_DELETAR_PET_CHAVE -> {
                setMessage(message);
                setApiCode(SUCESSO_DELETAR_PET_VALOR);
            }
        }
        setEntity(entity);
        setEntities(entities);
    }
}
