package br.com.eguadorodrigo.adopet.service;

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
                abrigoResponse.setEntidades(abrigos);
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
                abrigoResponse.setEntidade(abrigo.get());
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
            if(abrigoSalvo != null){
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SUCESSO_CADASTRAR_ABRIGO_CHAVE, ConstantesGlobais.SUCESSO_CADASTRAR_ABRIGO_VALOR);
                abrigoResponse.setEntidade(abrigoSalvo);
            }else{
                abrigoResponse = new AbrigoResponse(ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_CHAVE, ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_VALOR);
            }
            return abrigoResponse;
        }
    }
}
