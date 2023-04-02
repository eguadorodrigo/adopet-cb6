package br.com.eguadorodrigo.adopet.service;

import br.com.eguadorodrigo.adopet.model.AutenticacaoRequest;
import br.com.eguadorodrigo.adopet.model.AutenticacaoResponse;
import br.com.eguadorodrigo.adopet.model.RegistroRequest;
import br.com.eguadorodrigo.adopet.model.Usuario;
import br.com.eguadorodrigo.adopet.model.enums.RoleEnum;
import br.com.eguadorodrigo.adopet.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AutenticacaoResponse autenticar(AutenticacaoRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));
        Usuario usuario = usuarioRepository
                .buscarPorEmail(request.getEmail())
                .orElseThrow();

        String jwtToken = jwtService.gerarToken(usuario);

        return new AutenticacaoResponse(jwtToken);
    }

    public AutenticacaoResponse registrar(RegistroRequest request) {

        Usuario usuario = gerarUsuarioDaRequisicao(request);

        if(usuarioRepository
                .buscarPorEmail(request.getEmail())
                .isEmpty()){
            usuarioRepository.save(usuario);
        }

        String jwtToken = jwtService.gerarToken(usuario);

        return new AutenticacaoResponse(jwtToken);
    }

    private Usuario gerarUsuarioDaRequisicao(RegistroRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome().split(" ")[0]);
        usuario.setSobrenome(request.getNome().substring(request.getNome().indexOf(" ")-1));
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setRole(RoleEnum.USER);
        return usuario;
    }
}
