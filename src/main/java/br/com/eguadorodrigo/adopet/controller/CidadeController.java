package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.request.AbrigoRequest;
import br.com.eguadorodrigo.adopet.model.request.CidadeRequest;
import br.com.eguadorodrigo.adopet.model.response.CidadeResponse;
import br.com.eguadorodrigo.adopet.service.AbrigoService;
import br.com.eguadorodrigo.adopet.service.CidadeService;
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
@RequestMapping("/cidades")
@Tag(name = "Recurso de Cidade", description = "Controlador dos recursos de Cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping
    @Operation(summary = "Recurso para buscar todos os abrigos", description = "Recurso para buscar todos os abrigos")
    public ResponseEntity<CidadeResponse> buscarTodos(){
        return ResponseEntity.ok(cidadeService.buscarTodos());
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Recurso para buscar um abrigo por id", description = "Recurso para buscar um abrigo por id")
    public ResponseEntity<CidadeResponse> buscarPorId(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório") Long id){
        return ResponseEntity.ok(cidadeService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Recurso para cadastrar um abrigo", description = "Recurso para cadastrar um abrigo")
    public ResponseEntity<CidadeResponse> cadastrar(@Valid @RequestBody CidadeRequest cidadeRequest){
        return ResponseEntity.ok(cidadeService.cadastrar(cidadeRequest));
    }

    @PutMapping
    @Operation(summary = "Recurso para atualizar um abrigo", description = "Recurso para atualizar um abrigo")
    public ResponseEntity<CidadeResponse> atualizar(@Valid @RequestBody CidadeRequest cidadeRequest){
        return ResponseEntity.ok(cidadeService.atualizar(cidadeRequest));
    }

    @PatchMapping
    @Operation(summary = "Recurso para atualizar um dado de abrigo", description = "Recurso para atualizar um dado de abrigo")
    public ResponseEntity<CidadeResponse> atualizarParcial(@RequestBody CidadeRequest cidadeRequest){
        return ResponseEntity.ok(cidadeService.atualizarParcial(cidadeRequest));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Recurso para excluir um abrigo", description = "Recurso para excluir um abrigo")
    public ResponseEntity<CidadeResponse> deletar(@PathVariable @Valid @NotEmpty(message = "Código é obrigatório.") Long id){
        return ResponseEntity.ok(cidadeService.deletar(id));
    }
}
