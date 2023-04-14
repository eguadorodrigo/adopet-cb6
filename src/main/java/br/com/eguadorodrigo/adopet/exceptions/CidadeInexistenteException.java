package br.com.eguadorodrigo.adopet.exceptions;

public class CidadeInexistenteException extends RuntimeException {
    public CidadeInexistenteException(String message) {
        super(message);
    }
}
