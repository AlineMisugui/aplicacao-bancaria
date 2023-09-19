package org.example.exceptions;

public class FinanciamentoValorInvalidoException extends Exception{
    public FinanciamentoValorInvalidoException() {
        super("Quantidade a financiar inválida.");
    }
}
