package br.com.eguadordorigo.adopet.controller;

import br.com.eguadordorigo.adopet.model.Tutor;
import br.com.eguadordorigo.adopet.model.dto.TutorDto;
import br.com.eguadordorigo.adopet.service.TutorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Recurso de Tutores", description = "Operações que são possíveis dentro do escopo de Tutor")
public class TutorController {
    private TutorService tutorService;

    public TutorController(TutorService tutorService, ObjectMapper mapper) {
        this.tutorService = tutorService;
    }

    @Operation(description = "Recurso para criação de um tutor", summary = "Recurso para criação de um tutor")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity criar(@Valid @RequestBody TutorDto tutorDto) throws JsonProcessingException {
        return ResponseEntity.ok(tutorService.criar(tutorDto));
    }

    @Operation(description = "Recurso para buscar todos os tutores cadastrados", summary = "Recurso para buscar todos os tutores cadastrados")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Tutor>> listarTodos(){
        return new ResponseEntity<>(tutorService.listarTodos(), HttpStatus.OK);
    }

    @Operation(description = "Recurso para buscar o tutor pelo id", summary = "Recurso para buscar o tutor pelo id")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tutor> listarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(tutorService.listarPorId(id));
    }

    @Operation(description = "Recurso para atualizar um tutor", summary = "Recurso para atualizar um tutor")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tutor> atualizar(@Valid @RequestBody TutorDto tutorDto) throws JsonProcessingException {
        return ResponseEntity.ok(tutorService.atualizar(tutorDto));
    }

    @Operation(description = "Recurso para deletar um tutor", summary = "Recurso para deletar um tutor")
    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletar(@PathVariable  @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        tutorService.deletar(id);
        return new ResponseEntity("Tutor excluído.",HttpStatus.OK);
    }
}