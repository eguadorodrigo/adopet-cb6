package br.com.eguadordorigo.adopet.service;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.model.dto.TutorDto;

import java.util.List;

public interface TutorService {
    Tutor criar(TutorDto tutorDto);

    Tutor listarPorId(Long id);

    List<Tutor> listarTodos();

    Tutor atualizar(TutorDto tutorDto);

    void deletar(Long id);
}
