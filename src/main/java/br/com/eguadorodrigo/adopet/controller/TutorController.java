package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.TutorRequest;
import br.com.eguadorodrigo.adopet.model.TutorResponse;
import br.com.eguadorodrigo.adopet.service.TutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
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

@RestController
@RequestMapping("/tutores")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Recurso de Tutores", description = "Controlador dos recursos de Tutor")
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @Operation(description = "Recurso para criação de um tutor", summary = "Recurso para criação de um tutor")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorResponse> criar(@Valid @RequestBody TutorRequest tutorRequest){
        return ResponseEntity.ok(tutorService.criar(tutorRequest));
    }

    @Operation(description = "Recurso para buscar todos os tutores cadastrados", summary = "Recurso para buscar todos os tutores cadastrados")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorResponse> listarTodos(){
        return ResponseEntity.ok(tutorService.listarTodos());
    }

    @Operation(description = "Recurso para buscar o tutor pelo id", summary = "Recurso para buscar o tutor pelo id")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorResponse> listarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(tutorService.listarPorId(id));
    }

    @Operation(description = "Recurso para atualizar um tutor", summary = "Recurso para atualizar um tutor")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorResponse> atualizar(@Valid @RequestBody TutorRequest tutorRequest) {
        return ResponseEntity.ok(tutorService.atualizar(tutorRequest));
    }

    @Operation(description = "Recurso para deletar um tutor", summary = "Recurso para deletar um tutor")
    @DeleteMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TutorResponse> deletar(@PathVariable  @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(tutorService.deletar(id));
    }
}