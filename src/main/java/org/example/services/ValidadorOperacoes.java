package org.example.services;

import org.example.exceptions.*;
import org.example.negocios.Conta;

public class ValidadorOperacoes {
    public void validaQuantidadeDeposito(Double quantidade) throws DepositoValorInvalidoException {
        if (quantidade <= 0)
            throw new DepositoValorInvalidoException();
    }

    public void validaQuantidadePagamento(Double quantidade) throws PagamentoValorInvalidoException {
        if (quantidade <= 0)
            throw new PagamentoValorInvalidoException();
    }

    public void validaQuantidadeFinanciamento(Double quantidade) throws FinanciamentoValorInvalidoException {
        if (quantidade <= 0)
            throw new FinanciamentoValorInvalidoException();
    }

    public void validaQuantidadeAplicacao(Double quantidade) throws AplicacaoValorInvalidoException {
        if (quantidade <= 0)
            throw new AplicacaoValorInvalidoException();
    }

    public void validaSaldoSuficiente(Conta conta, Double quantidadeComparacao) throws SaldoInsuficienteException {
        if (conta.getSaldo() < quantidadeComparacao)
            throw new SaldoInsuficienteException();
    }
}
