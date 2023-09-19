package org.example.enums;

public enum TipoConta {
    CORRENTE(1, "Conta corrente"),
    POUPANCA(2, "Conta poupança"),
    SALARIAL(3, "Conta salarial"),
    CONJUNTA(4, "Conta conjunta");

    private int id;
    private String tipoConta;

    TipoConta(int id, String tipoConta) {
        this.id = id;
        this.tipoConta = tipoConta;
    }
}
