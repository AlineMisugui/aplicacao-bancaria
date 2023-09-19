package org.example.negocios;

import org.example.clientes.Empresa;
import org.example.clientes.Pessoa;
import org.example.clientes.Titular;
import org.example.enums.TipoConta;

import java.util.Date;
import java.util.List;


public class Conta {
    private String numero;
    private TipoConta tipoConta;
    private Titular titular;
    private Double saldo;
    private Date dataAbertura;
    private List<Transacao> transacoes;

    public Conta(String numero, TipoConta tipoConta, Titular titular, Double saldo, Date dataAbertura) {
        this.numero = numero;
        this.tipoConta = tipoConta;
        this.titular = titular;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
    }

    @Override
    public String toString() {
        String nomeTitular = "";
        if (titular instanceof Pessoa) {
            nomeTitular = ((Pessoa) titular).getNomeCompleto();
        } else if (titular instanceof Empresa) {
            nomeTitular = ((Empresa) titular).getNomeFantasia();
        }

        return "Número da Conta: " + numero + "\n" +
                "Tipo de Conta: " + tipoConta + "\n" +
                "Titular: " + nomeTitular + "\n" +
                "Saldo: " + saldo + "\n" +
                "Data de Abertura: " + dataAbertura;
    }

    public String getNumero() {
        return numero;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Titular titular() {
        return titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
