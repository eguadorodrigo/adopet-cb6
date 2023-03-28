package br.com.eguadordorigo.adopet.service;

import br.com.eguadordorigo.adopet.model.Tutor;

import java.util.List;
import java.util.Optional;

public interface TutorService {
    Tutor criarTutor(Tutor tutor);

    Optional<Tutor> buscarUsuarioPorId(Long id);

    List<Tutor> buscarTodos();

    Tutor atualizarUsuario(Tutor tutor);

    void deleteUsuario(Long id);
}
