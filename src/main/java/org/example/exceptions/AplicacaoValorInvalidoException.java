package org.example.exceptions;

public class AplicacaoValorInvalidoException extends Exception {
    public AplicacaoValorInvalidoException() {
        super("Quantidade a aplicar inválida.");
    }
}
