package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.exceptions.ConstantesExceptions;
import br.com.eguadorodrigo.adopet.model.ConstantesGlobais;
import br.com.eguadorodrigo.adopet.model.Tutor;
import br.com.eguadorodrigo.adopet.model.TutorRequest;
import br.com.eguadorodrigo.adopet.model.TutorResponse;
import br.com.eguadorodrigo.adopet.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

public interface TutorService {
    TutorResponse criar(TutorRequest tutorRequest);

    TutorResponse listarPorId(Long id);

    TutorResponse listarTodos();

    TutorResponse atualizar(TutorRequest tutorRequest);

    TutorResponse deletar(Long id);

    @Service
    class TutorServiceImpl implements TutorService {

        private final TutorRepository tutorRepository;

        private final PasswordEncoder passwordEncoder;

        public TutorServiceImpl(TutorRepository tutorRepository, PasswordEncoder passwordEncoder) {
            this.tutorRepository = tutorRepository;
            this.passwordEncoder = passwordEncoder;
        }

        @Override
        public TutorResponse criar(TutorRequest tutorRequest) {
            Tutor tutor = new Tutor();
            BeanUtils.copyProperties(tutorRequest, tutor);
            tutorRepository.save(tutor);
            TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_CRIAR_TUTOR_CHAVE, ConstantesGlobais.SUCESSO_CRIAR_TUTOR_VALOR);
            tutorResponse.setEntity(tutor);
            return tutorResponse;
        }

        @Override
        public TutorResponse listarPorId(Long id) {
            Tutor tutor = tutorRepository.findById(id).orElseThrow(()-> new RuntimeException(ConstantesExceptions.USUARIO_NAO_ENCONTRADO));
            TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_LISTAR_TUTOR_POR_ID_CHAVE, ConstantesGlobais.SUCESSO_LISTAR_TUTOR_POR_ID_VALOR);
            tutorResponse.setEntity(tutor);
            return tutorResponse;
        }

        @Override
        public TutorResponse listarTodos() {
            TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_LISTAR_TUTORES_CHAVE, ConstantesGlobais.SUCESSO_LISTAR_TUTORES_VALOR);
            tutorResponse.setEntities(tutorRepository.findAll());
            return tutorResponse;
        }

        @Override
        public TutorResponse atualizar(TutorRequest tutorRequest) {

            Tutor tutorConvertido = new Tutor();
            BeanUtils.copyProperties(tutorRequest, tutorConvertido);

            Tutor tutorTemp = tutorRepository.findById(tutorConvertido.getId()).orElseThrow(()-> new RuntimeException(ConstantesExceptions.USUARIO_NAO_ENCONTRADO));
            tutorTemp.setNome(tutorConvertido.getNome());
            tutorTemp.setSobrenome(tutorConvertido.getSobrenome());
            tutorTemp.setEmail(tutorConvertido.getEmail());
            tutorTemp.setSenha(passwordEncoder.encode(tutorConvertido.getSenha()));
            tutorTemp.setRole(tutorConvertido.getRole());

            Tutor tutorAtual = tutorRepository.save(tutorTemp);

            TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_ATUALIZAR_TUTOR_CHAVE, ConstantesGlobais.SUCESSO_ATUALIZAR_TUTOR_VALOR);
            tutorResponse.setEntity(tutorAtual);

            return tutorResponse;
        }

        @Override
        public TutorResponse deletar(Long id) {
            tutorRepository.deleteById(id);
            TutorResponse tutorResponse = new TutorResponse(ConstantesGlobais.SUCESSO_DELETAR_TUTOR_CHAVE, ConstantesGlobais.SUCESSO_DELETAR_TUTOR_VALOR);
            return tutorResponse;
        }
    }
}
