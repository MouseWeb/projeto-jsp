package br.com.desafio.model;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void testIdGetterSetter() {
        Long id = 1L;
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        assertEquals(id, pessoa.getId());
    }

    @Test
    void testNomeGetterSetter() {
        String nome = "John Doe";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        assertEquals(nome, pessoa.getNome());
    }

    @Test
    void testDataNascimentoGetterSetter() {
        Date dataNascimento = new Date();
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(dataNascimento);
        assertEquals(dataNascimento, pessoa.getDataNascimento());
    }

    @Test
    void testCpfGetterSetter() {
        String cpf = "123.456.789-00";
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(cpf);
        assertEquals(cpf, pessoa.getCpf());
    }

    @Test
    void testFuncionarioGetterSetter() {
        Boolean funcionario = true;
        Pessoa pessoa = new Pessoa();
        pessoa.setFuncionario(funcionario);
        assertEquals(funcionario, pessoa.getFuncionario());
    }

    @Test
    void testPessoaColGetterSetter() {
        String pessoaCol = "ABC";
        Pessoa pessoa = new Pessoa();
        pessoa.setPessoaCol(pessoaCol);
        assertEquals(pessoaCol, pessoa.getPessoaCol());
    }

}