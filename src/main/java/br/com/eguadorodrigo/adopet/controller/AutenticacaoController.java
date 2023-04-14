package br.com.eguadorodrigo.adopet.controller;

import br.com.eguadorodrigo.adopet.model.request.AutenticacaoRequest;
import br.com.eguadorodrigo.adopet.model.response.AutenticacaoResponse;
import br.com.eguadorodrigo.adopet.model.request.RegistroRequest;
import br.com.eguadorodrigo.adopet.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@Tag(name = "Recursos de Atenticação", description = "Controlador dos recursos de autenticação")
public class AutenticacaoController {
    private final AuthenticationService authenticationService;

    public AutenticacaoController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/autenticar")
    @Operation(summary = "Recurso para realizar uma autenticação", description = "Recurso para realizar uma autenticação")
    public ResponseEntity<AutenticacaoResponse> autenticar(@RequestBody AutenticacaoRequest request){
        return ResponseEntity.ok(authenticationService.autenticar(request));
    }

    @PostMapping("/registrar")
    @Operation(summary = "Recurso para criar uma autenticação", description = "Recurso para criar uma autenticação")
    public ResponseEntity<AutenticacaoResponse> registrar(@RequestBody RegistroRequest request){
        return ResponseEntity.ok(authenticationService.registrar(request));
    }

}
