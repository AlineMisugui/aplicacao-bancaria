package org.example.interfaces;

import org.example.enums.TipoAplicacao;
import org.example.exceptions.*;
import org.example.negocios.Conta;
import org.example.enums.FormaPagamento;

public interface Operacoes {
    public String realizarDeposito(Double quantidade, Double saldoAtual) throws DepositoValorInvalidoException;
    public String realizarPagamento(Conta contaDestino, Double quantidade, FormaPagamento formaPagamento) throws PagamentoValorInvalidoException;
    public String verificarSaldo(Conta conta) throws SaldoNuloException;
    public String solicitarFinanciamento(Double rendaMensal, Double quantidade) throws FinanciamentoValorInvalidoException;
    public String realizarAplicacao(Conta conta, TipoAplicacao tipoAplicacao, Double quantidade)
            throws AplicacaoValorInvalidoException, SaldoInsuficienteException;
    public String gerarExtratoPorPeriodo(Conta conta, int mes) ;
}
