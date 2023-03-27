package br.com.eguadordorigo.adopet;

import java.util.List;
import java.util.Optional;

public interface TutorService {
    Tutor criarUsuario(Tutor tutor);

    Optional<Tutor> buscarUsuarioPorId(Long id);

    List<Tutor> buscarTodos();

    Tutor atualizarUsuario(Tutor tutor);

    void deleteUsuario(Long id);
}
