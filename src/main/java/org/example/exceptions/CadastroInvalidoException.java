package org.example.exceptions;

public class CadastroInvalidoException extends Exception {
    public CadastroInvalidoException(String mensagem) {
        super(mensagem);
    }
}
