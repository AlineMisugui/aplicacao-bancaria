package org.example.services;

import org.example.enums.*;
import org.example.exceptions.*;
import org.example.negocios.Conta;
import org.example.clientes.Pessoa;
import org.example.clientes.Titular;
import org.example.negocios.Transacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OperacoesServiceTest {
    @Test
    public void realizaDeposito() throws DepositoValorInvalidoException {
        OperacoesService service = new OperacoesService();
        String resultado = service.realizarDeposito(1000.00, 15000.00);
        Assertions.assertEquals("Valor depositado.", resultado);
    }

    @Test
    public void depositoComQuantidadeInvalida() throws DepositoValorInvalidoException {
        String resultado = null;
        try {
            OperacoesService service = new OperacoesService();
            resultado = service.realizarDeposito(-10.0, 15000.00);
        } catch (DepositoValorInvalidoException e) {
            resultado = e.getMessage();
        }
        Assertions.assertEquals("Quantidade a depositar inválida.", resultado);
    }

    @Test
    public void realizaPagamento() throws PagamentoValorInvalidoException {
        OperacoesService service = new OperacoesService();
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);
        Conta contaDestino = new Conta("BB092348", TipoConta.CORRENTE, titular, 5000.00, new Date());

        String resultado = service.realizarPagamento(contaDestino, 100.00, FormaPagamento.PIX);
        Assertions.assertEquals("Pagamento concluído.", resultado);
    }

    @Test
    public void pagamentoComQuantidadeInvalida() throws PagamentoValorInvalidoException {
        String resultado = null;
        try {
            OperacoesService service = new OperacoesService();
            Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                    "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                    EstadoCivil.SOLTEIRO, null);
            Conta contaDestino = new Conta("BB092348", TipoConta.CORRENTE, titular, 5000.00, new Date());

            resultado = service.realizarPagamento(contaDestino, -100.00, FormaPagamento.PIX);
        } catch (PagamentoValorInvalidoException e) {
            resultado = e.getMessage();
        }
        Assertions.assertEquals("Quantidade a pagar inválida.", resultado);
    }

    @Test
    public void visualizaSaldo() throws SaldoNuloException {
        OperacoesService service = new OperacoesService();
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);
        Conta conta = new Conta("BB092348", TipoConta.CORRENTE, titular, 5000.00, new Date());
        String resultado = service.verificarSaldo(conta);
        Assertions.assertEquals("Saldo atual: R$ 5.000,00", resultado);
    }

    @Test
    public void solicitaFinanciamento() throws FinanciamentoValorInvalidoException {
        OperacoesService service = new OperacoesService();
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);
        Conta conta = new Conta("BB092348", TipoConta.CORRENTE, titular, 10000.00, new Date());
        String resultado = service.solicitarFinanciamento(5000.00, 500.00);
        Assertions.assertEquals("Financiamento aprovado.", resultado);
    }

    @Test
    public void realizaAplicacao() throws AplicacaoValorInvalidoException, SaldoInsuficienteException {
        OperacoesService service = new OperacoesService();
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);
        Conta conta = new Conta("BB092348", TipoConta.CORRENTE, titular, 10000.00, new Date());
        String resultado = service.realizarAplicacao(conta, TipoAplicacao.FUNDOS_INVESTIMENTO, 5000.00);
        System.out.println(resultado);
        Assertions.assertEquals("Aplicação realizada com sucesso.", resultado);
    }

    @Test
    public void aplicacaoComSaldoInsuficiente()  throws AplicacaoValorInvalidoException, SaldoInsuficienteException {
        String resultado = "";
        try {
            OperacoesService service = new OperacoesService();
            Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                    "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                    EstadoCivil.SOLTEIRO, null);
            Conta conta = new Conta("BB092348", TipoConta.CORRENTE, titular, 10000.00, new Date());
            resultado = service.realizarAplicacao(conta, TipoAplicacao.FUNDOS_INVESTIMENTO, 15000.00);
        } catch (SaldoInsuficienteException e) {
            resultado = e.getMessage();
        }
        Assertions.assertEquals("Saldo insuficiente", resultado);
    }

    @Test
    public void geraExtratoParaAgosto() {
        OperacoesService service = new OperacoesService();
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);
        Conta conta = new Conta("BB092348", TipoConta.CORRENTE, titular, 5000.00, new Date());

        List<Transacao> transacoes = new ArrayList<>();
        transacoes.add(new Transacao("1003294", "Depósito", TipoTransacao.DEPOSITO, new Date(123, Calendar.AUGUST, 10)));
        transacoes.add(new Transacao("5000900", "Saque", TipoTransacao.FINANCIAMENTO, new Date(123, Calendar.AUGUST, 19)));
        transacoes.add(new Transacao("5464566", "Depósito", TipoTransacao.PAGAMENTO, new Date(123, Calendar.APRIL, 23)));

        conta.setTransacoes(transacoes);
        String extratoDoMes = service.gerarExtratoPorPeriodo(conta, 8);

        String expectedExtrato = "Extrato do mês 8:\n" +
                "Data: 10/08/2023, Descrição: Depósito, Id da transação: 1003294\n" +
                "Data: 19/08/2023, Descrição: Solicitação de financiamento, Id da transação: 5000900\n";

        Assertions.assertEquals(expectedExtrato, extratoDoMes);
    }
}
