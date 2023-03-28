package br.com.eguadordorigo.adopet.service;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.repository.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements TutorService {

    private TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor criar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor listarPorId(Long id) {
        return tutorRepository.findById(id).orElseThrow(()-> new RuntimeException("Tutor não encontrado"));
    }

    @Override
    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor atualizar(Tutor tutor) {
        Tutor usr = tutorRepository.findById(tutor.getId()).orElseThrow(()-> new RuntimeException("Não foi possível encontrar usuário."));
        usr.setNome(tutor.getNome());
        usr.setEmail(tutor.getEmail());
        usr.setSenha(tutor.getSenha());
        Tutor tutorAtual = tutorRepository.save(usr);
        return tutorAtual;
    }

    @Override
    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }
}
