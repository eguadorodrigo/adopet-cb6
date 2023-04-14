package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.entities.Cidade;
import br.com.eguadorodrigo.adopet.model.request.CidadeRequest;
import br.com.eguadorodrigo.adopet.model.response.CidadeResponse;
import br.com.eguadorodrigo.adopet.repository.CidadeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

public interface CidadeService {
    CidadeResponse buscarTodos();
    CidadeResponse buscarPorId(Long id);
    CidadeResponse cadastrar(CidadeRequest cidadeRequest);
    CidadeResponse atualizar(CidadeRequest cidadeRequest);
    CidadeResponse atualizarParcial(CidadeRequest cidadeRequest);
    CidadeResponse deletar(Long id);


    @Service
    class CidadeServiceImpl implements CidadeService{
        private final CidadeRepository cidadeRepository;

        public CidadeServiceImpl(CidadeRepository cidadeRepository) {
            this.cidadeRepository = cidadeRepository;
        }


        @Override
        public CidadeResponse buscarTodos() {
            return null;
        }

        @Override
        public CidadeResponse buscarPorId(Long id) {
            return null;
        }

        @Override
        public CidadeResponse cadastrar(CidadeRequest cidadeRequest) {
            Cidade cidade = new Cidade();
            BeanUtils.copyProperties(cidadeRequest, cidade);
            return new CidadeResponse(ConstantesGlobais.SUCESSO_CADASTRAR_CIDADE_CHAVE, cidadeRepository.save(cidade), null);
        }

        @Override
        public CidadeResponse atualizar(CidadeRequest cidadeRequest) {
            return null;
        }

        @Override
        public CidadeResponse atualizarParcial(CidadeRequest cidadeRequest) {
            return null;
        }

        @Override
        public CidadeResponse deletar(Long id) {
            return null;
        }
    }

}
