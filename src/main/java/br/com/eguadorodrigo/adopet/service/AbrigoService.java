package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.AbrigoInexistenteException;
import br.com.eguadorodrigo.adopet.exceptions.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.model.Abrigo;
import br.com.eguadorodrigo.adopet.model.AbrigoRequest;
import br.com.eguadorodrigo.adopet.model.AbrigoResponse;
import br.com.eguadorodrigo.adopet.model.ConstantesGlobais;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AbrigoService {

    AbrigoResponse buscarTodos();

    AbrigoResponse buscarPorId(Long id);

    AbrigoResponse cadastrar(AbrigoRequest abrigoRequest);

    AbrigoResponse atualizar(AbrigoRequest abrigoRequest);

    AbrigoResponse atualizarParcial(AbrigoRequest abrigoRequest);

    AbrigoResponse deletar(Long id);

    @Service
    class AbrigoServiceImpl implements AbrigoService{
        private final AbrigoRepository repository;

        public AbrigoServiceImpl(AbrigoRepository repository) {
            this.repository = repository;
        }

        @Override
        public AbrigoResponse buscarTodos() {
            List<Abrigo> abrigos = repository.findAll();
            AbrigoResponse abrigoResponse;
            if(abrigos.size()>0) {
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_BUSCAR_ABRIGOS_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_ABRIGOS_VALOR);
                abrigoResponse.setEntities(abrigos);
            }else{
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_CHAVE, ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_VALOR);
            }
            return abrigoResponse;
        }

        @Override
        public AbrigoResponse buscarPorId(Long id) {
            Optional<Abrigo> abrigo = repository.findById(id);
            AbrigoResponse abrigoResponse;
            if(abrigo.isPresent()) {
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_BUSCAR_ABRIGO_POR_ID_CHAVE, ConstantesGlobais.SUCESSO_BUSCAR_ABRIGO_POR_ID_VALOR);
                abrigoResponse.setEntity(abrigo.get());
            }else{
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_CHAVE, ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_VALOR);
            }
            return abrigoResponse;
        }

        @Override
        public AbrigoResponse cadastrar(AbrigoRequest abrigoRequest) {
            Abrigo abrigo = new Abrigo();
            BeanUtils.copyProperties(abrigoRequest, abrigo);
            Abrigo abrigoSalvo = repository.save(abrigo);
            AbrigoResponse abrigoResponse;
            abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_CADASTRAR_ABRIGO_CHAVE, ConstantesGlobais.SUCESSO_CADASTRAR_ABRIGO_VALOR);
            abrigoResponse.setEntity(abrigoSalvo);
            return abrigoResponse;
        }

        @Override
        public AbrigoResponse atualizar(AbrigoRequest abrigoRequest) {

            Abrigo abrigo = new Abrigo();
            BeanUtils.copyProperties(abrigoRequest, abrigo);
            Abrigo abrigoEncontrado = repository.findById(abrigo.getId()).orElseThrow(()-> new AbrigoInexistenteException(ConstantesExceptions.ABRIGO_NAO_ENCONTRADO));

            abrigoEncontrado.setNome(abrigo.getNome());
            abrigoEncontrado.setDescricao(abrigo.getDescricao());
            abrigoEncontrado.setCidade(abrigo.getCidade());
            abrigoEncontrado.setTelefone(abrigo.getTelefone());

            Abrigo abrigoAtualizado = repository.save(abrigoEncontrado);

            AbrigoResponse abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_ABRIGO_CHAVE, ConstantesGlobais.SUCESSO_ATUALIZAR_ABRIGO_VALOR);
            abrigoResponse.setEntity(abrigoAtualizado);

            return abrigoResponse;
        }



        @Override
        public AbrigoResponse atualizarParcial(AbrigoRequest abrigoRequest) {
            Abrigo abrigoEncontrado = repository.findById(abrigoRequest.getId()).orElseThrow(()-> new AbrigoInexistenteException(ConstantesExceptions.ABRIGO_NAO_ENCONTRADO));

            if(abrigoRequest.getNome() != null){
                abrigoEncontrado.setNome(abrigoRequest.getNome());
            }
            if(abrigoRequest.getCidade() != null){
                abrigoEncontrado.setCidade(abrigoRequest.getCidade());
            }
            if(abrigoRequest.getDescricao() != null){
                abrigoEncontrado.setDescricao(abrigoRequest.getDescricao());
            }
            if(abrigoRequest.getTelefone() != null){
                abrigoEncontrado.setTelefone(abrigoRequest.getTelefone());
            }

            Abrigo abrigoAtualizado = repository.save(abrigoEncontrado);

            AbrigoResponse abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_ABRIGO_PARCIAL_CHAVE, ConstantesGlobais.SUCESSO_ATUALIZAR_ABRIGO_PARCIAL_VALOR);
            abrigoResponse.setEntity(abrigoAtualizado);

            return abrigoResponse;
        }

        @Override
        public AbrigoResponse deletar(Long id) {
            Abrigo abrigo = repository.findById(id).orElseThrow(()-> new AbrigoInexistenteException(ConstantesExceptions.ABRIGO_NAO_ENCONTRADO));
            repository.delete(abrigo);
            return new AbrigoResponse(ConstantesGlobais.SUCESSO_DELETAR_ABRIGO_CHAVE, ConstantesGlobais.SUCESSO_DELETAR_ABRIGO_VALOR);
        }
    }
}
