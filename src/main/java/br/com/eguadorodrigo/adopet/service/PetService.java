package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.exceptions.UsuarioInexistenteException;
import br.com.eguadorodrigo.adopet.model.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.Pets;
import br.com.eguadorodrigo.adopet.model.PetsRequest;
import br.com.eguadorodrigo.adopet.model.PetsResponse;
import br.com.eguadorodrigo.adopet.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {

    PetsResponse buscarTodos();

    PetsResponse buscarPorId(Long id);

    PetsResponse cadastrar(PetsRequest petsRequest);

    @Service
    class PetServiceImpl implements PetService{

        private final PetRepository petRepository;

        public PetServiceImpl(PetRepository petRepository) {
            this.petRepository = petRepository;
        }

        @Override
        public PetsResponse buscarTodos() {
            List<Pets> pets = petRepository.findAll();
            PetsResponse petsResponse = new PetsResponse(ConstantesGlobais.SUCESSO_BUSCAR_PETS_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_PETS_VALUE);
            petsResponse.setEntidades(pets);
            return petsResponse;
        }

        @Override
        public PetsResponse buscarPorId(Long id) {
            Pets pets = petRepository.findById(id).orElseThrow(() -> new UsuarioInexistenteException(ConstantesExceptions.USUARIO_INEXISTENTE));
            PetsResponse petsResponse = new PetsResponse(ConstantesGlobais.SUCESSO_BUSCAR_PET_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_PET_VALUE);
            petsResponse.setEntidade(pets);
            return petsResponse;
        }

        @Override
        public PetsResponse cadastrar(PetsRequest petsRequest) {
            Pets pets = new Pets();
            BeanUtils.copyProperties(petsRequest, pets);
            petRepository.save(pets);
            PetsResponse petsResponse = new PetsResponse(ConstantesGlobais.SUCESSO_CADASTRAR_PET_CHAVE,ConstantesGlobais.SUCESSO_CADASTRAR_PET_VALOR);
            petsResponse.setEntidade(pets);
            return petsResponse;
        }
    }
}


