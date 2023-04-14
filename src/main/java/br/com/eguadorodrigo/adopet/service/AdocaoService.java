package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.model.contants.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.entities.Adocao;
import br.com.eguadorodrigo.adopet.model.request.AdocaoRequest;
import br.com.eguadorodrigo.adopet.model.response.AdocaoResponse;
import br.com.eguadorodrigo.adopet.repository.AdocaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdocaoService {

    AdocaoResponse buscarTodos();

    AdocaoResponse buscarPorId(Long id);

    AdocaoResponse cadastrar(AdocaoRequest adocaoRequest);

    AdocaoResponse atualizar(AdocaoRequest adocaoRequest);

    AdocaoResponse atualizarParcial(AdocaoRequest adocaoRequest);

    AdocaoResponse deletar(Long id);

    @Service
    class AdocaoServiceImpl implements AdocaoService {
        private final AdocaoRepository repository;

        public AdocaoServiceImpl(AdocaoRepository repository) {
            this.repository = repository;
        }

        @Override
        public AdocaoResponse buscarTodos() {
            List<Adocao> adocaoList = repository.findAll();
            if(adocaoList.size()>0) {
                return new AdocaoResponse(ConstantesGlobais.SUCESSO_LISTAR_ADOCAO_CHAVE, null, adocaoList);
            }else {
                return new AdocaoResponse(ConstantesGlobais.SEM_REGISTROS_PARA_EXIBIR_CHAVE, null, null);
            }
        }

        @Override
        public AdocaoResponse buscarPorId(Long id) {
            return null;
        }

        @Override
        public AdocaoResponse cadastrar(AdocaoRequest adocaoRequest) {
            Adocao adocao = new Adocao();
            BeanUtils.copyProperties(adocaoRequest, adocao);
            return new AdocaoResponse(ConstantesGlobais.SUCESSO_CADASTRAR_ADOCAO_CHAVE, repository.save(adocao), null);
        }

        @Override
        public AdocaoResponse atualizar(AdocaoRequest adocaoRequest) {
            return null;
        }

        @Override
        public AdocaoResponse atualizarParcial(AdocaoRequest adocaoRequest) {
            return null;
        }

        @Override
        public AdocaoResponse deletar(Long id) {
            return null;
        }
    }
}
