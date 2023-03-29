package br.com.eguadordorigo.adopet.service.impl;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.repository.TutorRepository;
import br.com.eguadordorigo.adopet.service.TutorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorServiceImpl implements TutorService {

    private TutorRepository tutorRepository;

    public TutorServiceImpl(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public Tutor criar(TutorDto tutorDto) {
        Tutor tutor = new Tutor();
        BeanUtils.copyProperties(tutorDto, tutor);
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
    public Tutor atualizar(TutorDto tutorDto) {

        Tutor tutorConvertido = new Tutor();
        BeanUtils.copyProperties(tutorDto, tutorConvertido);

        Tutor tutorTemp = tutorRepository.findById(tutorConvertido.getId()).orElseThrow(()-> new RuntimeException("Não foi possível encontrar usuário."));
        tutorTemp.setNome(tutorConvertido.getNome());
        tutorTemp.setEmail(tutorConvertido.getEmail());
        tutorTemp.setSenha(tutorConvertido.getSenha());

        Tutor tutorAtual = tutorRepository.save(tutorTemp);

        return tutorAtual;
    }

    @Override
    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }
}
