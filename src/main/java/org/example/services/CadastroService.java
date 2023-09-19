package org.example.services;

import org.example.negocios.Conta;
import org.example.clientes.Empresa;
import org.example.clientes.Pessoa;
import org.example.clientes.Titular;
import org.example.enums.TipoConta;
import org.example.exceptions.CadastroInvalidoException;

import java.util.Date;
import java.util.Random;

public class CadastroService {
    public Conta cadastrar(Titular titular, TipoConta tipoConta, Double saldoInicial) throws CadastroInvalidoException {
        try {
            if (titular instanceof Pessoa) {
                Pessoa pessoa = (Pessoa) titular;
                this.cadastraPessoa(pessoa, tipoConta, saldoInicial);
                Conta conta = this.criaConta(tipoConta, pessoa, saldoInicial);
                return conta;
            } else if (titular instanceof Empresa) {
                Empresa empresa = (Empresa) titular;
                this.cadastraEmpresa(empresa, tipoConta, saldoInicial);
                Conta conta = this.criaConta(tipoConta, empresa, saldoInicial);
                return conta;
            } else {
                throw new CadastroInvalidoException("Tipo de titular inválido!");
            }
        } catch (CadastroInvalidoException e) {
            throw new CadastroInvalidoException(e.getMessage());
        }
    }


    private Conta criaConta(TipoConta tipoConta, Titular titular, Double saldoInicial)
    {
        String numero = this.geraNumeroContaAleatorio();
        Date dataAbertura = new Date();
        Conta conta = new Conta(numero, tipoConta, titular, saldoInicial, dataAbertura);
        return conta;
    }

    private String geraNumeroContaAleatorio()
    {
        Random random = new Random();
        return String.format("%010d", random.nextInt(1000000000));
    }

    private void cadastraPessoa(Pessoa pessoa, TipoConta tipoConta, Double saldoInicial) throws CadastroInvalidoException
    {
        ValidadorDadosCadastrais validadorDados = new ValidadorDadosCadastrais();
        validadorDados.validaCpf(pessoa.getCpf());
        validadorDados.validaCep(pessoa.getCep());
        validadorDados.validaTelefone(pessoa.getTelefone());

        ValidadorCadastro validador = new ValidadorCadastro();
        switch (tipoConta) {
            case CONJUNTA:
                validador.validaContaConjunta(pessoa.getEstadoCivil());
                break;
            case POUPANCA:
                validador.validaContaPoupanca(saldoInicial);
                break;
        }
    }

    private void cadastraEmpresa(Empresa empresa, TipoConta tipoConta, Double saldoInicial) throws CadastroInvalidoException
    {
        ValidadorDadosCadastrais validadorDados = new ValidadorDadosCadastrais();
        validadorDados.validaCnpj(empresa.getCnpj());
        validadorDados.validaCep(empresa.getCep());
        validadorDados.validaTelefone(empresa.getTelefone());

        ValidadorCadastro validador = new ValidadorCadastro();
        validador.validaContaEmpresa(tipoConta);
    }
}
