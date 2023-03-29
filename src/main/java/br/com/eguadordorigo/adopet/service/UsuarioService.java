package br.com.eguadordorigo.adopet.service;

import br.com.eguadordorigo.adopet.model.dto.AcessoDto;
import br.com.eguadordorigo.adopet.model.dto.UsuarioDto;

public interface UsuarioService {

    String login(UsuarioDto usuarioDto);

    String criarAcesso(AcessoDto acessoDto);
}
