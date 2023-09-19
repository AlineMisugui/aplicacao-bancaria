package org.example.services;

import org.example.exceptions.CadastroInvalidoException;

public class ValidadorDadosCadastrais {
    public String validaCpf(String cpf) throws CadastroInvalidoException
    {
        if (cpf == null)
            throw new CadastroInvalidoException("O CPF deve ser informado.");
        String cpfFormatado = cpf.replaceAll("[^0-9]", "");
        if (cpfFormatado.length() != 11)
            throw new CadastroInvalidoException("Tamanho de CPF inválido.");
        return cpfFormatado;
    }

    public String validaTelefone(String telefone) throws CadastroInvalidoException{
        if (telefone == null)
            throw new CadastroInvalidoException("O Telefone deve ser informado.");
        String cpfFormatado = telefone.replaceAll("[^0-9]", "");
        if (cpfFormatado.length() < 10||cpfFormatado.length() > 11)
            throw new CadastroInvalidoException("Tamanho de Telefone inválido.");
        return cpfFormatado;
    }

    public String validaCep(String cep) throws CadastroInvalidoException {
        if (cep == null)
            throw new CadastroInvalidoException("O CEP deve ser informado.");
        String cpfFormatado = cep.replaceAll("[^0-9]", "");
        if (cpfFormatado.length() != 8)
            throw new CadastroInvalidoException("Tamanho de CEP inválido.");
        return cpfFormatado;
    }

    public String validaCnpj(String cnpj) throws CadastroInvalidoException {
        if (cnpj == null)
            throw new CadastroInvalidoException("O CNPJ deve ser informado.");
        String cpfFormatado = cnpj.replaceAll("[^0-9]", "");
        if (cpfFormatado.length() != 14)
            throw new CadastroInvalidoException("Tamanho de CNPJ inválido.");
        return cpfFormatado;
    }
}
