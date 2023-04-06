package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.PetsRequest;
import br.com.eguadorodrigo.adopet.model.PetsResponse;
import br.com.eguadorodrigo.adopet.service.PetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public ResponseEntity<PetsResponse> buscarTodos(){
        return ResponseEntity.ok(petService.buscarTodos());
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Recurso para buscar um pet", description = "Recurso para buscar um pet")
    public ResponseEntity<PetsResponse> buscarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(petService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Recurso para cadastrar um pet", description = "Recurso para cadastrar um pet")
    public ResponseEntity<PetsResponse> cadastrar(@Valid @RequestBody PetsRequest petsRequest){
        return ResponseEntity.ok(petService.cadastrar(petsRequest));
    }

}
