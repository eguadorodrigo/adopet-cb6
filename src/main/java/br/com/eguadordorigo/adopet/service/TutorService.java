package br.com.eguadordorigo.adopet.service;

import br.com.eguadordorigo.adopet.model.Tutor;

import java.util.List;

public interface TutorService {
    Tutor criar(Tutor tutor);

    Tutor listarPorId(Long id);

    List<Tutor> listarTodos();

    Tutor atualizar(Tutor tutor);

    void deletar(Long id);
}
