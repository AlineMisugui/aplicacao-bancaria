package org.example.exceptions;

public class PagamentoValorInvalidoException extends Exception{
    public PagamentoValorInvalidoException() {
        super("Quantidade a pagar inválida.");
    }
}
