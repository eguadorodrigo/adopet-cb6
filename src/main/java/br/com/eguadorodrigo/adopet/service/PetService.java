package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.AbrigoInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.CidadeInexistenteException;
import br.com.eguadorodrigo.adopet.model.contants.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.exceptions.PetInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.TutorInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.UsuarioInexistenteException;
import br.com.eguadorodrigo.adopet.model.entities.Abrigo;
import br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.entities.Pet;
import br.com.eguadorodrigo.adopet.model.request.PetRequest;
import br.com.eguadorodrigo.adopet.model.response.PetResponse;
import br.com.eguadorodrigo.adopet.repository.AbrigoRepository;
import br.com.eguadorodrigo.adopet.repository.CidadeRepository;
import br.com.eguadorodrigo.adopet.repository.PetRepository;
import br.com.eguadorodrigo.adopet.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

        private final CidadeRepository cidadeRepository;

        private final TutorRepository tutorRepository;

        public PetServiceImpl(PetRepository petRepository, AbrigoRepository abrigoRepository, CidadeRepository cidadeRepository, TutorRepository tutorRepository) {
            this.petRepository = petRepository;
            this.abrigoRepository = abrigoRepository;
            this.cidadeRepository = cidadeRepository;
            this.tutorRepository = tutorRepository;
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
            Pet petEncontrado = petRepository
                    .findById(request.getId())
                    .orElseThrow(() -> new PetInexistenteException(ConstantesExceptions.PET_NAO_ENCONTRADO));

            petEncontrado.setNome(request.getNome());
            petEncontrado.setDescricao(request.getDescricao());
            petEncontrado.setAdotado(request.getAdotado());
            petEncontrado.setIdade(request.getIdade());
            if(!Objects.equals(petEncontrado.getCidade().getId(),request.getCidadeId()))
                petEncontrado.setCidade(cidadeRepository.findById(request.getCidadeId()).orElseThrow(()-> new CidadeInexistenteException(ConstantesExceptions.CIDADE_NAO_ENCOTRADA)));

            petEncontrado.setPorte(request.getPorte());
            petEncontrado.setImagem(request.getImagem());

            if(!Objects.equals(petEncontrado.getAbrigo().getId(), request.getAbrigoId()))
                petEncontrado.setAbrigo(abrigoRepository.findById(request.getAbrigoId()).orElseThrow(()-> new AbrigoInexistenteException(ConstantesExceptions.ABRIGO_NAO_ENCONTRADO)));

            if(!Objects.equals(petEncontrado.getTutor().getId(), request.getTutorId()))
                petEncontrado.setTutor(tutorRepository.findById(request.getTutorId()).orElseThrow(()-> new TutorInexistenteException(ConstantesExceptions.USUARIO_INEXISTENTE)));

            return new PetResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_PET_PARCIAL_CHAVE, petRepository.save(petEncontrado), null);
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


