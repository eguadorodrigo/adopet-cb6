package br.com.eguadordorigo.adopet.controller;

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
@Tag(name = "Recursos de Usuário", description = "Controlador dos recursos de Usuário")
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    @Operation(description = "Recurso para realizar login na aplicação")
    public ResponseEntity<String> login(@Valid @NotEmpty(message = "Campo nome não pode ser vazio") String nome,
                                        @Valid @NotEmpty(message = "Campo senha não pode ser vazio") String senha){
        return ResponseEntity.ok(service.login(new UsuarioDto(nome, senha)));
    }

    @PostMapping("/criarAcesso")
    @Operation(description = "Recurso para criar o acesso na aplicação")
    public ResponseEntity<String> criarAcesso(@Valid @RequestBody AcessoDto acessoDto){
        return ResponseEntity.ok(service.criarAcesso(acessoDto));
    }

}
