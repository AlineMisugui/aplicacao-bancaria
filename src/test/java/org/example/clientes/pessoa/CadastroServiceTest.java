package org.example.clientes.pessoa;

import org.example.negocios.Conta;
import org.example.clientes.Pessoa;
import org.example.clientes.Titular;
import org.example.enums.EstadoCivil;
import org.example.enums.TipoConta;
import org.example.exceptions.CadastroInvalidoException;
import org.example.services.CadastroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CadastroServiceTest {
    @Test
    public void cadastraContaCorrente() throws CadastroInvalidoException
    {
        Titular titular = new Pessoa("85031-360", 100, "Jardim Itália", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, null);

        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.CORRENTE, 0.0);
        System.out.println(conta);
        Assertions.assertEquals(conta, conta);
    }

    @Test
    public void cadastraContaConjunta() throws CadastroInvalidoException
    {
        Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.CASADO, "052.003.259-43");

        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.CONJUNTA, 0.0);
        System.out.println(conta);
        Assertions.assertEquals(conta, conta);
    }

    @Test
    public void pessoaSolteiraCadastraContaConjunta() throws CadastroInvalidoException
    {
        try {
            Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                    "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                    EstadoCivil.SOLTEIRO, "052.003.259-43");
            CadastroService service = new CadastroService();
            Conta conta = service.cadastrar(titular, TipoConta.CONJUNTA, 0.0);
        } catch (CadastroInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void cadastraContaCorrenteComCpfInvalido() throws CadastroInvalidoException
    {
        try {
            Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                    "547.659.6", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                    EstadoCivil.SOLTEIRO, "052.003.259-43");
            CadastroService service = new CadastroService();
            Conta conta = service.cadastrar(titular, TipoConta.CORRENTE, 0.0);
        } catch (CadastroInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void cadastraContaPoupanca() throws CadastroInvalidoException
    {
        Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, "052.003.259-43");
        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.POUPANCA, 100.0);
        System.out.println(conta);
        Assertions.assertEquals(conta, conta);
    }

    @Test
    public void cadastraContaPoupancaSemSaldoInicialSuficiente() throws CadastroInvalidoException
    {
        try {
            Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                    "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                    EstadoCivil.SOLTEIRO, "052.003.259-43");
            CadastroService service = new CadastroService();
            Conta conta = service.cadastrar(titular, TipoConta.POUPANCA, 0.0);
        } catch (CadastroInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void cadastraContaSalarial() throws CadastroInvalidoException
    {
        Titular titular = new Pessoa("85031-360", 100, "Jardim Iguaçú", "(44)99989-2567",
                "547.659.629-11", "Aline Ayumi Misugui", new Date(10, 8, 2002),
                EstadoCivil.SOLTEIRO, "052.003.259-43");
        CadastroService service = new CadastroService();
        Conta conta = service.cadastrar(titular, TipoConta.SALARIAL, 0.0);
        System.out.println(conta);
        Assertions.assertEquals(conta, conta);
    }
}
