package br.com.eguadordorigo.adopet.auth;

import br.com.eguadordorigo.adopet.model.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Recursos de Atenticação", description = "Controlador dos recursos de autenticação")
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {
    private final AuthenticationService authenticationService;

    public AutenticacaoController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/autenticar")
    @Operation(description = "Recurso para realizar login na aplicação")
    public ResponseEntity<AuthenticationResponse> autenticar(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.autenticar(request));
    }

    @PostMapping("/registrar")
    @Operation(description = "Recurso para criar o acesso na aplicação")
    public ResponseEntity<AuthenticationResponse> registrar(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.registrar(request));
    }

}
