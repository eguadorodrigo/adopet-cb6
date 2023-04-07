package br.com.eguadorodrigo.adopet.exceptions;

public class AbrigoInexistenteException extends RuntimeException {
    public AbrigoInexistenteException(String mensagem) {
        super(mensagem);
    }
}
