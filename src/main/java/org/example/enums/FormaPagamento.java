package org.example.enums;

public enum FormaPagamento {
    CARTAO_DE_CREDITO(1, "Cartão de crédito"),
    CARTAO_DE_DEBITO(2, "Cartão de débito"),
    TRANSFERENCIA_ELETRONICA(3, "Transferência Eletrônica"),
    TRANSFERENCIA_INTERNACIONAL(4, "Tranferência Internacional"),
    PIX(5, "Pix"),
    CHEQUE(6, "Cheque");

    private int id;
    private String formaPagamento;

    FormaPagamento(int id, String formaPagamento) {
        this.id = id;
        this.formaPagamento = formaPagamento;
    }
}
