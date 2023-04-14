package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.request.PetRequest;
import br.com.eguadorodrigo.adopet.model.response.PetResponse;
import br.com.eguadorodrigo.adopet.service.PetService;
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
@RequestMapping("/pets")
@Tag(name = "Recurso de Pet", description = "Controlador dos recursos de Pet")
public class PetsController {

    private final PetService petService;

    public PetsController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    @Operation(summary = "Recurso para buscar todos os pets", description = "Recurso para buscar todos os pets")
    public ResponseEntity<PetResponse> buscarTodos(){
        return ResponseEntity.ok(petService.buscarTodos());
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Recurso para buscar um pet", description = "Recurso para buscar um pet")
    public ResponseEntity<PetResponse> buscarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(petService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Recurso para cadastrar um pet", description = "Recurso para cadastrar um pet")
    public ResponseEntity<PetResponse> cadastrar(@Valid @RequestBody PetRequest petRequest){
        return ResponseEntity.ok(petService.cadastrar(petRequest));
    }

    @PutMapping
    @Operation(summary = "Recurso para atualizar um pet", description = "Recurso para atualizar um pet")
    public ResponseEntity<PetResponse> atualizar(@Valid @RequestBody PetRequest petRequest){
        return ResponseEntity.ok(petService.atualizar(petRequest));
    }

    @PatchMapping
    @Operation(summary = "Recurso para atualizar um dado de pet", description = "Recurso para atualizar um dado de pet")
    public ResponseEntity<PetResponse> atualizarParcial(@RequestBody PetRequest petRequest){
        return ResponseEntity.ok(petService.atualizarParcial(petRequest));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Recurso para atualizar um dado de pet", description = "Recurso para atualizar um dado de pet")
    public ResponseEntity<PetResponse> deletar(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(petService.deletar(id));
    }

}
