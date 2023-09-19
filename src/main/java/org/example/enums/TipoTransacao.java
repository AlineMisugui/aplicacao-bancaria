package org.example.enums;

public enum TipoTransacao {
    DEPOSITO(1, "Depósito"),
    PAGAMENTO(2, "Pagamento"),
    VERIFICACAO_SALDO(3, "Verificação de saldo"),
    FINANCIAMENTO(4, "Solicitação de financiamento"),
    APLICACAO(5, "Aplicação financeira"),
    EXTRATO_POR_PERIODO(6, "Geração de extrato por período");

    private int id;
    private String tipoTransacao;
    TipoTransacao(int id, String tipoTransacao) {
        this.id = id;
        this.tipoTransacao = tipoTransacao;
    }

    public int getId() {
        return id;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }
}
