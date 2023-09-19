package org.example.enums;

public enum TipoAplicacao {
    CDB(1, "Certificado de Depósito Bancário"),
    RDB(2, "Recibo de Depósito Bancário"),
    POUPANCA(3, "Poupança"),
    FUNDOS_INVESTIMENTO(4, "Fundos de Investimento");

    private int id;
    private String tipoAplicacao;
    TipoAplicacao(int id, String tipoAplicacao) {
        this.id = id;
        this.tipoAplicacao = tipoAplicacao;
    }
}
