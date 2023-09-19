package org.example.clientes;

public abstract class Titular {
    private String cep;
    private int numero;
    private String complemento;
    private String telefone;

    public Titular(String cep, int numero, String complemento, String telefone) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getTelefone() {
        return telefone;
    }
}
