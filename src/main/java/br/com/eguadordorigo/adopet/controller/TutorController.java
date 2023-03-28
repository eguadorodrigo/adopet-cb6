package br.com.eguadordorigo.adopet.controller;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private TutorService tutorService;

    private ObjectMapper mapper;

    private ObjectWriter ow;


    public TutorController(TutorService tutorService, ObjectMapper mapper) {
        this.tutorService = tutorService;
        this.mapper = mapper;
        this.ow = mapper.writer().withDefaultPrettyPrinter();
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> buscarTodos(){
        List<Tutor> tutors = tutorService.buscarTodos();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criarTutor(@Valid @RequestBody TutorDto tutorDto) throws JsonProcessingException {
        Tutor tutor = mapper.readValue(ow.writeValueAsString(tutorDto), Tutor.class);
        return ResponseEntity.ok(tutorService.criarTutor(tutor));
    }

}
