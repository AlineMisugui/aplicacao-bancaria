package org.example.negocios;

import org.example.enums.TipoTransacao;

import java.util.Date;

public class Transacao {
    private String id;
    private String idConta;
    private TipoTransacao tipoTransacao;
    private Date data;

    public Transacao(String id, String idConta, TipoTransacao tipoTransacao, Date data) {
        this.id = id;
        this.idConta = idConta;
        this.tipoTransacao = tipoTransacao;
        this.data = data;
    }

    public Date getData() {
        return data;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public String getId() {
        return id;
    }
}
