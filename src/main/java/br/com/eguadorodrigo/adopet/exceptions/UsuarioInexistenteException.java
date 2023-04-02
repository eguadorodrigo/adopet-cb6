package br.com.eguadorodrigo.adopet.exceptions;

public class UsuarioInexistenteException extends RuntimeException {
    public UsuarioInexistenteException(String mensagem) {
        super(mensagem);
    }
}
