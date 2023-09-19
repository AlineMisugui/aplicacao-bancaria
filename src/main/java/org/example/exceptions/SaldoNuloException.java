package org.example.exceptions;

public class SaldoNuloException extends Exception {
    public SaldoNuloException() {
        super("Não é possível realizar operação.");
    }
}
