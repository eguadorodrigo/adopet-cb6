package br.com.eguadordorigo.adopet.auth;

import br.com.eguadordorigo.adopet.model.AuthenticationResponse;
import br.com.eguadordorigo.adopet.model.Usuario;
import br.com.eguadordorigo.adopet.repository.UsuarioRepository;
import br.com.eguadordorigo.adopet.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

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

    public AuthenticationResponse autenticar(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha()));
        Usuario usuario = usuarioRepository
                .buscarPorEmail(request.getEmail())
                .orElseThrow();

        String jwtToken = jwtService.gerarToken(usuario);

        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse registrar(RegisterRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome().split(" ")[0]);
        usuario.setSobrenome(request.getNome().substring(request.getNome().indexOf(" ")));
        usuario.setEmail(request.getEmail());
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        usuario.setExpiracao(Date.from(Instant.now()));

        usuarioRepository.save(usuario);

        String jwtToken = jwtService.gerarToken(usuario);

        return new AuthenticationResponse(jwtToken);
    }
}
