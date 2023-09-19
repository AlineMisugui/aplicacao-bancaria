package org.example.clientes;

import org.example.enums.EstadoCivil;

import java.util.Date;

public class Pessoa extends Titular {
    private String cpf;
    private String nomeCompleto;
    private Date dataNascimento;
    private EstadoCivil estadoCivil;
    private String cpfConjuge;

    public Pessoa(String cep, int numero, String complemento, String telefone, String cpf, String nomeCompleto, Date dataNascimento, EstadoCivil estadoCivil, String cpfConjuge) {
        super(cep, numero, complemento, telefone);
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
        this.cpfConjuge = cpfConjuge;
        this.verificaNecessidadeDeVinculoComConjuge();
    }

    private void verificaNecessidadeDeVinculoComConjuge()
    {
        if (estadoCivil.getId() == 2) {
            if (cpfConjuge == null || cpfConjuge.isEmpty()) {
                throw new IllegalArgumentException("CPF do cônjuge é obrigatório para pessoas casadas.");
            }
            this.cpfConjuge = cpfConjuge;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public String getCpfConjuge() {
        return cpfConjuge;
    }
}
