package br.com.eguadorodrigo.adopet.exceptions;

public class PetInexistenteException extends RuntimeException {
    public PetInexistenteException(String mensagem) {
        super(mensagem);
    }
}
