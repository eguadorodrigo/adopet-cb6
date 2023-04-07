package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.AbrigoRequest;
import br.com.eguadorodrigo.adopet.model.AbrigoResponse;
import br.com.eguadorodrigo.adopet.service.AbrigoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/abrigos")
@Tag(name = "Recurso de Abrigo", description = "Controlador dos recursos de Abrigo")
public class AbrigoController {

    private final AbrigoService abrigoService;

    public AbrigoController(AbrigoService abrigoService) {
        this.abrigoService = abrigoService;
    }

    @GetMapping
    @Operation(summary = "Recurso para buscar todos os abrigos", description = "Recurso para buscar todos os abrigos")
    public ResponseEntity<AbrigoResponse> buscarTodos(){
        return ResponseEntity.ok(abrigoService.buscarTodos());
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Recurso para buscar um abrigo por id", description = "Recurso para buscar um abrigo por id")
    public ResponseEntity<AbrigoResponse> buscarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(abrigoService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Recurso para buscar um abrigo por id", description = "Recurso para buscar um abrigo por id")
    public ResponseEntity<AbrigoResponse> cadastrar(@Valid @RequestBody AbrigoRequest abrigoRequest){
        return ResponseEntity.ok(abrigoService.cadastrar(abrigoRequest));
    }

    @PutMapping
    @Operation(summary = "Recurso para atualizar um abrigo", description = "Recurso para atualizar um abrigo")
    public ResponseEntity<AbrigoResponse> atualizar(@Valid @RequestBody AbrigoRequest abrigoRequest){
        return ResponseEntity.ok(abrigoService.atualizar(abrigoRequest));
    }

    @PatchMapping
    @Operation(summary = "Recurso para atualizar um dado de abrigo", description = "Recurso para atualizar um dado de abrigo")
    public ResponseEntity<AbrigoResponse> atualizarParcial(@RequestBody AbrigoRequest abrigoRequest){
        return ResponseEntity.ok(abrigoService.atualizarParcial(abrigoRequest));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Recurso para buscar um abrigo por id", description = "Recurso para buscar um abrigo por id")
    public ResponseEntity<AbrigoResponse> deletar(@PathVariable @Valid @NotEmpty(message = "Código do abrigo é obrigatório.") Long id){
        return ResponseEntity.ok(abrigoService.deletar(id));
    }
}
