package org.example.clientes.empresa;

import org.example.negocios.Conta;
import org.example.clientes.Empresa;
import org.example.clientes.Titular;
import org.example.enums.TipoConta;
import org.example.exceptions.CadastroInvalidoException;
import org.example.services.CadastroService;
import org.junit.jupiter.api.Test;

public class CadastroServiceTest {
    @Test
    public void cadastraEmpresaContaCorrente() throws CadastroInvalidoException {
        Titular titular = new Empresa("85031-360", 100, "Jardim Iguaçú", "(44)99943-5645",
                "34.678.456/0001-87", "Neymar Jr Company", "Ney");

        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.CORRENTE, 0.0);
        System.out.println(conta);
    }

    @Test
    public void cadastraEmpresaContaPoupanca() throws CadastroInvalidoException{
        Titular titular = new Empresa("85031-360", 100, "Jardim Iguaçú", "(44)99943-5645",
                "34.678.456/0001-87", "Neymar Jr Company", "Ney");

        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.POUPANCA, 0.0);
        System.out.println(conta);
    }

    @Test
    public void cadastraEmpresaCnpjInvalido() throws CadastroInvalidoException {
        try {
            Titular titular = new Empresa("85031-360", 100, "Jardim Iguaçú", "(44)99943-5645",
                    "34.678.456/0", "Neymar Jr Company", "Ney");

            CadastroService service = new CadastroService();
            Conta conta = service.cadastrar(titular, TipoConta.POUPANCA, 0.0);
            System.out.println(conta);
        } catch (CadastroInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void tentaCadastrarEmpresaConjunta() throws CadastroInvalidoException {
        try {
            Titular titular = new Empresa("85031-360", 100, "Jardim Iguaçú", "(44)99943-5645",
                    "34.678.456/0001-87", "Neymar Jr Company", "Ney");

            CadastroService service = new CadastroService();
            Conta conta = service.cadastrar(titular, TipoConta.CONJUNTA, 0.0);
            System.out.println(conta);
        } catch (CadastroInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
