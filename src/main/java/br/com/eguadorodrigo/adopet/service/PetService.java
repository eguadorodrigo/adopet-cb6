package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.exceptions.UsuarioInexistenteException;
import br.com.eguadorodrigo.adopet.model.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.Pet;
import br.com.eguadorodrigo.adopet.model.PetResponse;
import br.com.eguadorodrigo.adopet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {

    PetResponse buscarTodos();

    PetResponse buscarPorId(Long id);

    @Service
    class PetServiceImpl implements PetService{

        private final PetRepository petRepository;

        public PetServiceImpl(PetRepository petRepository) {
            this.petRepository = petRepository;
        }

        @Override
        public PetResponse buscarTodos() {
            List<Pet> pets = petRepository.findAll();
            PetResponse petResponse = new PetResponse(ConstantesGlobais.SUCESSO_BUSCAR_PETS_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_PETS_VALUE);
            petResponse.setEntidades(pets);
            return petResponse;
        }

        @Override
        public PetResponse buscarPorId(Long id) {
            Pet pet = petRepository.findById(id).orElseThrow(() -> new UsuarioInexistenteException(ConstantesExceptions.USUARIO_INEXISTENTE));
            PetResponse petResponse = new PetResponse(ConstantesGlobais.SUCESSO_BUSCAR_PET_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_PET_VALUE);
            petResponse.setEntidade(pet);
            return petResponse;
        }
    }
}


