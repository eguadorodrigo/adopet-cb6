package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.request.AdocaoRequest;
import br.com.eguadorodrigo.adopet.model.response.AdocaoResponse;
import br.com.eguadorodrigo.adopet.service.AdocaoService;
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
@RequestMapping("/adocao")
@Tag(name = "Recurso de Adoção", description = "Controlador dos recursos de Adoção")
public class AdocaoController {

    private final AdocaoService adocaoService;

    public AdocaoController(AdocaoService adocaoService) {
        this.adocaoService = adocaoService;
    }

    @GetMapping
    @Operation(summary = "Recurso para buscar todas as adoções", description = "Recurso para buscar todas as adoções")
    public ResponseEntity<AdocaoResponse> buscarTodos(){
        return ResponseEntity.ok(adocaoService.buscarTodos());
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Recurso para buscar uma adoção por id", description = "Recurso para buscar uma adoção por id")
    public ResponseEntity<AdocaoResponse> buscarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(adocaoService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Recurso para cadastrar uma adoção", description = "Recurso para cadastrar uma adoção")
    public ResponseEntity<AdocaoResponse> cadastrar(@Valid @RequestBody AdocaoRequest adocaoRequest){
        return ResponseEntity.ok(adocaoService.cadastrar(adocaoRequest));
    }

    @PutMapping
    @Operation(summary = "Recurso para atualizar uma adoção", description = "Recurso para atualizar uma adoção")
    public ResponseEntity<AdocaoResponse> atualizar(@Valid @RequestBody AdocaoRequest adocaoRequest){
        return ResponseEntity.ok(adocaoService.atualizar(adocaoRequest));
    }

    @PatchMapping
    @Operation(summary = "Recurso para atualizar um dado de adoção", description = "Recurso para atualizar um dado de adoção")
    public ResponseEntity<AdocaoResponse> atualizarParcial(@RequestBody AdocaoRequest adocaoRequest){
        return ResponseEntity.ok(adocaoService.atualizarParcial(adocaoRequest));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Recurso para deletar uma adoção", description = "Recurso para deletar uma adoção")
    public ResponseEntity<AdocaoResponse> deletar(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório.") Long id){
        return ResponseEntity.ok(adocaoService.deletar(id));
    }
}
