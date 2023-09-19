package org.example.clientes;

public class Empresa extends Titular {
    private String cnpj;
    private String nomeEmpresarial;
    private String nomeFantasia;

    public Empresa(String cep, int numero, String complemento, String telefone, String cnpj, String nomeEmpresarial, String nomeFantasia) {
        super(cep, numero, complemento, telefone);
        this.cnpj = cnpj;
        this.nomeEmpresarial = nomeEmpresarial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }
}
