package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.AbrigoInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.exceptions.PetInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.UsuarioInexistenteException;
import br.com.eguadorodrigo.adopet.model.Abrigo;
import br.com.eguadorodrigo.adopet.model.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.Pet;
import br.com.eguadorodrigo.adopet.model.PetRequest;
import br.com.eguadorodrigo.adopet.model.PetResponse;
import br.com.eguadorodrigo.adopet.repository.PetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {

    PetResponse buscarTodos();
    PetResponse buscarPorId(Long id);
    PetResponse cadastrar(PetRequest petRequest);
    PetResponse atualizar(PetRequest petRequest);
    PetResponse atualizarParcial(PetRequest petRequest);
    PetResponse deletar(Long id);

    @Service
    class PetServiceImpl implements PetService{

        private final PetRepository petRepository;

        private final AbrigoRepository abrigoRepository;

        public PetServiceImpl(PetRepository petRepository, AbrigoRepository abrigoRepository) {
            this.petRepository = petRepository;
            this.abrigoRepository = abrigoRepository;
        }

        @Override
        public PetResponse buscarTodos() {
            List<Pet> pets = petRepository.findAll();
            return new PetResponse(ConstantesGlobais.SUCESSO_BUSCAR_PETS_CHAVE, null, pets);
        }

        @Override
        public PetResponse buscarPorId(Long id) {
            Pet petEncontrado = petRepository
                    .findById(id)
                    .orElseThrow(() -> new UsuarioInexistenteException(ConstantesExceptions.PET_NAO_ENCONTRADO));
            return new PetResponse(ConstantesGlobais.SUCESSO_BUSCAR_PET_CHAVE, petEncontrado, null);
        }

        @Override
        public PetResponse cadastrar(PetRequest petRequest) {
            Pet pet = new Pet();
            Abrigo abrigo = abrigoRepository
                    .findById(petRequest.getAbrigoId())
                    .orElseThrow(()-> new AbrigoInexistenteException(ConstantesExceptions.ABRIGO_NAO_ENCONTRADO));
            BeanUtils.copyProperties(petRequest, pet);
            pet.setAbrigo(abrigo);
            Pet petCadastrado = petRepository.save(pet);
            return new PetResponse(ConstantesGlobais.SUCESSO_CADASTRAR_PET_CHAVE, petCadastrado, null);
        }

        @Override
        public PetResponse atualizar(PetRequest petRequest) {
            Pet pet = petRepository
                    .findById(petRequest.getId())
                    .orElseThrow(()-> new PetInexistenteException(ConstantesExceptions.PET_NAO_ENCONTRADO));
            BeanUtils.copyProperties(petRequest, pet);
            Pet petAtualizado = petRepository.save(pet);
            return new PetResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_PET_CHAVE, petAtualizado, null);
        }

        @Override
        public PetResponse atualizarParcial(PetRequest request) {
            Pet pet = petRepository
                    .findById(request.getId())
                    .orElseThrow(() -> new PetInexistenteException(ConstantesExceptions.PET_NAO_ENCONTRADO));
            Pet petAtualizado = petRepository.save(pet.requestToPet(request));
            return new PetResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_PET_PARCIAL_CHAVE, petAtualizado, null);
        }

        @Override
        public PetResponse deletar(Long id) {
            Pet pet = petRepository
                    .findById(id)
                    .orElseThrow(() -> new PetInexistenteException(ConstantesExceptions.PET_NAO_ENCONTRADO));
            petRepository.delete(pet);
            return new PetResponse(ConstantesGlobais.SUCESSO_DELETAR_PET_CHAVE, null, null);
        }
    }
}


