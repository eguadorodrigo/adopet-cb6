package br.com.eguadordorigo.adopet.auth;

import br.com.eguadordorigo.adopet.model.AuthenticationResponse;
import br.com.eguadordorigo.adopet.model.dto.AcessoDto;
import br.com.eguadordorigo.adopet.model.dto.UsuarioDto;
import br.com.eguadordorigo.adopet.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Recursos de Atenticação", description = "Controlador dos recursos de autenticação")
@RequestMapping("/api/v1/auth")
public class AutenticacaoController {
    private UsuarioService service;

    public AutenticacaoController(UsuarioService service, ObjectMapper mapper) {
        this.service = service;
    }

    @PostMapping("/autenticar")
    @Operation(description = "Recurso para realizar login na aplicação")
    public ResponseEntity<AuthenticationResponse> autenticar(@Valid @NotEmpty(message = "Campo nome não pode ser vazio") String nome,
                                                             @Valid @NotEmpty(message = "Campo senha não pode ser vazio") String senha){
        return ResponseEntity.ok(service.login(new UsuarioDto(nome, senha)));
    }

    @PostMapping("/registrar")
    @Operation(description = "Recurso para criar o acesso na aplicação")
    public ResponseEntity<AuthenticationResponse> registrar(@Valid @RequestBody AcessoDto acessoDto){
        return ResponseEntity.ok(service.criarAcesso(acessoDto));
    }

}
