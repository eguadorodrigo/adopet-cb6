package br.com.eguadordorigo.adopet.service.impl;

import br.com.eguadordorigo.adopet.model.Usuario;
import br.com.eguadordorigo.adopet.model.dto.AcessoDto;
import br.com.eguadordorigo.adopet.model.dto.UsuarioDto;
import br.com.eguadordorigo.adopet.repository.UsuarioRepository;
import br.com.eguadordorigo.adopet.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public String login(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDto, usuario);

        Usuario usuarioEncontrado = repository.buscarPorEmail(usuario.getEmail()).orElseThrow();

        if(!usuario.getSenha().equals(usuarioEncontrado.getSenha())){
            throw new RuntimeException("Acesso negado");
        }
        return "Login com sucesso";
    }

    @Override
    public String criarAcesso(AcessoDto acessoDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(acessoDto, usuario);
        repository.save(usuario);
        return "Cadastro realizado";
    }
}
