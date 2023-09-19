package org.example.enums;

public enum FormaDeposito {
    DINHEIRO(1, "Dinheiro"),
    CHEQUE(2, "Cheque"),
    TRANSFERENCIA(3, "Transferência");

    private int id;
    private String formaDeposito;

    FormaDeposito(int id, String formaDeposito) {
        this.id = id;
        this.formaDeposito = formaDeposito;
    }
}
