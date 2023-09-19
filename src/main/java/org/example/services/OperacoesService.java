package org.example.services;

import org.example.enums.TipoAplicacao;
import org.example.exceptions.*;
import org.example.negocios.Aplicacao;
import org.example.negocios.Conta;
import org.example.enums.FormaPagamento;
import org.example.interfaces.Operacoes;
import org.example.negocios.Transacao;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class OperacoesService implements Operacoes {
    @Override
    public String realizarDeposito(Double quantidade, Double saldoAtual) throws DepositoValorInvalidoException {
        ValidadorOperacoes service = new ValidadorOperacoes();
        service.validaQuantidadeDeposito(quantidade);
        saldoAtual += quantidade;
        return "Valor depositado.";
    }

    @Override
    public String realizarPagamento(Conta contaDestino, Double quantidade, FormaPagamento formaPagamento) throws PagamentoValorInvalidoException {
        ValidadorOperacoes service = new ValidadorOperacoes();
        service.validaQuantidadePagamento(quantidade);
        Double total = contaDestino.getSaldo() + quantidade;
        contaDestino.setSaldo(total);
        return "Pagamento concluído.";
    }

    @Override
    public String verificarSaldo(Conta conta) throws SaldoNuloException {
        try {
            if (conta.getSaldo() == null)
                throw new SaldoNuloException();
            Locale brasil = new Locale("pt", "BR");
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(brasil);
            String saldoFormatado = formatoMoeda.format(conta.getSaldo());
            return "Saldo atual: " + saldoFormatado;
        } catch (SaldoNuloException e) {
            return e.getMessage();
        }
    }

    @Override
    public String solicitarFinanciamento(Double rendaMensal, Double quantidade) throws FinanciamentoValorInvalidoException {
        ValidadorOperacoes service = new ValidadorOperacoes();
        service.validaQuantidadeFinanciamento(quantidade);
        double rendaMensalMaxima = 5000.00;
        double limiteFinanciamento = 10000.00;

        if (rendaMensalMaxima >= rendaMensal && limiteFinanciamento >= quantidade) {
            return "Financiamento aprovado.";
        } else {
            return "Financiamento negado.";
        }
    }

    @Override
    public String realizarAplicacao(Conta conta, TipoAplicacao tipoAplicacao, Double quantidade)
            throws AplicacaoValorInvalidoException, SaldoInsuficienteException {
        ValidadorOperacoes service = new ValidadorOperacoes();
        service.validaQuantidadeAplicacao(quantidade);
        service.validaSaldoSuficiente(conta, quantidade);
        Aplicacao aplicacao = new Aplicacao(quantidade, conta.getNumero(), new Date(), tipoAplicacao);
        return "Aplicação realizada com sucesso.";
    }

    @Override
    public String gerarExtratoPorPeriodo(Conta conta, int mes) {
        List<Transacao> transacoes = conta.getTransacoes();
        StringBuilder extrato = new StringBuilder("Extrato do mês " + mes + ":\n");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        for (Transacao transacao : transacoes) {
            Date dataTransacao = transacao.getData();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataTransacao);

            int mesTransacao = calendar.get(Calendar.MONTH) + 1;

            if (mesTransacao == mes) {
                extrato.append("Data: ").append(dateFormat.format(dataTransacao))
                        .append(", Descrição: ").append(transacao.getTipoTransacao().getTipoTransacao())
                        .append(", Id da transação: ").append(transacao.getId())
                        .append("\n");
            }
        }
        return extrato.toString();
    }
}
