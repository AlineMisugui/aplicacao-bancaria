package org.example.services;

import org.example.enums.EstadoCivil;
import org.example.enums.TipoConta;
import org.example.exceptions.CadastroInvalidoException;

public class ValidadorCadastro {
    public void validaContaConjunta(EstadoCivil estadoCivil) throws CadastroInvalidoException
    {
        if (estadoCivil != EstadoCivil.CASADO)
            throw new CadastroInvalidoException("Conta conjunta apenas para pessoas com estado civil casado(a).");
    }

    public void validaContaEmpresa(TipoConta tipoConta) throws CadastroInvalidoException
    {
        if (tipoConta == TipoConta.CONJUNTA || tipoConta == TipoConta.SALARIAL)
            throw new CadastroInvalidoException("Contas empresariais só podem ser conjuntas ou correntes.");
    }

    public void validaContaPoupanca(Double saldoInicial) throws CadastroInvalidoException
    {
        if (saldoInicial < 50.0)
            throw new CadastroInvalidoException("Saldo mínimo para abrir uma conta poupança de R$50,00.");
    }
}
