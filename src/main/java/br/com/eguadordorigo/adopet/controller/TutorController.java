package br.com.eguadordorigo.adopet.controller;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@Valid @RequestBody TutorDto tutorDto) throws JsonProcessingException {
        Tutor tutor = mapper.readValue(ow.writeValueAsString(tutorDto), Tutor.class);
        return ResponseEntity.ok(tutorService.criar(tutor));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tutor>> listarTodos(){
        List<Tutor> tutors = tutorService.listarTodos();
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tutor> listarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(tutorService.listarPorId(id));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tutor> atualizar(@Valid @RequestBody TutorDto tutorDto) throws JsonProcessingException {
        Tutor tutor = mapper.readValue(ow.writeValueAsString(tutorDto), Tutor.class);
        return ResponseEntity.ok(tutorService.atualizar(tutor));
    }

    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletar(@PathVariable  @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        tutorService.deletar(id);
        return new ResponseEntity("Tutor excluído.",HttpStatus.OK);
    }
}