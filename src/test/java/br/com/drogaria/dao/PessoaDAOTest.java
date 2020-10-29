package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoCidade = 1L; // salvar cidade com id do estado
		CidadeDAO cidadeDAO = new CidadeDAO(); // Buscar primeiro o estado para depois cadastrar a cidade
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Benedito Leite2");
		pessoa.setCpf("56656656652");
		pessoa.setRg("16665559");
		pessoa.setRua("Rua do Genipapo");
		pessoa.setNumero(new Short("25"));
		pessoa.setBairro("Parque União");
		pessoa.setCep("55626987");
		pessoa.setComplemento("");
		pessoa.setTelefone("(34)3222-3222");
		pessoa.setCelular("(34)98888-5555");
		pessoa.setEmail("benedito@gmail.com");
		pessoa.setCidade(cidade);

		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		System.out.println("Total de " + "'" + resultado.size() + "'" + " registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Pessoa pessoa : resultado) {
			System.out.println("Id: " + pessoa.getCodigo());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Fone: " + pessoa.getTelefone());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());

			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L; // código que quero pesquisar
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Objeto não encontrado");
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Id: " + pessoa.getCodigo());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Fone: " + pessoa.getTelefone());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());

			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 7L; // código que quero pesquisar
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Objeto não encontrado!");
			// JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Objeto excluído com sucesso!");
			// JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoPessoa = 5L;
		Long codigoCidade = 3L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);

		System.out.println("Código do Cidade: " + cidade.getCodigo());
		System.out.println("Nome do Cidade: " + cidade.getNome());
		System.out.println("Sigla do Cidade: " + cidade.getEstado().getNome());

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		pessoa.setNome("Benedito Leite232");
		pessoa.setCpf("56656656652");
		pessoa.setRg("166655592");
		pessoa.setRua("Rua do Genipapo2");
		pessoa.setNumero(new Short("252"));
		pessoa.setBairro("Parque União2");
		pessoa.setCep("556269872");
		pessoa.setComplemento("");
		pessoa.setTelefone("(34)3222-3222");
		pessoa.setCelular("(34)98888-5552");
		pessoa.setEmail("benedito@gmail.com2");
		pessoa.setCidade(cidade);

		pessoaDAO.editar(pessoa);

		System.out.println("RESULTADO DA BUSCA");
		System.out.println("Id: " + pessoa.getCodigo());
		System.out.println("Bairro: " + pessoa.getBairro());
		System.out.println("Celular: " + pessoa.getCelular());
		System.out.println("CEP: " + pessoa.getCep());
		System.out.println("Complemento: " + pessoa.getComplemento());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Email: " + pessoa.getEmail());
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Numero: " + pessoa.getNumero());
		System.out.println("RG: " + pessoa.getRg());
		System.out.println("Rua: " + pessoa.getRua());
		System.out.println("Fone: " + pessoa.getTelefone());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		System.out.println();
	}
}