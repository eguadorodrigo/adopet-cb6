package br.com.eguadordorigo.adopet;

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
    public Tutor criarUsuario(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Optional<Tutor> buscarUsuarioPorId(Long id) {
        return tutorRepository.findById(id);
    }

    @Override
    public List<Tutor> buscarTodos() {
        return tutorRepository.findAll();
    }

    @Override
    public Tutor atualizarUsuario(Tutor tutor) {
        Tutor usr = tutorRepository.findById(tutor.getId()).orElseThrow(()-> new RuntimeException("Não foi possível encontrar usuário."));
        usr.setNome(tutor.getNome());
        usr.setEmail(tutor.getEmail());
        usr.setSenha(tutor.getSenha());
        Tutor tutorAtual = tutorRepository.save(usr);
        return tutorAtual;
    }

    @Override
    public void deleteUsuario(Long id) {
        tutorRepository.deleteById(id);
    }
}
