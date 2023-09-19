package org.example.negocios;

import org.example.enums.TipoAplicacao;

import java.util.Date;

public class Aplicacao {
    private Double valor;
    private String numeroConta;
    private Date dataAplicacao;
    private TipoAplicacao tipoAplicacao;

    public Aplicacao(Double valor, String numeroConta, Date dataAplicacao, TipoAplicacao tipoAplicacao) {
        this.valor = valor;
        this.numeroConta = numeroConta;
        this.dataAplicacao = dataAplicacao;
        this.tipoAplicacao = tipoAplicacao;
    }
}
