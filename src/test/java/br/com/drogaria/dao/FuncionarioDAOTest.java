package br.com.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoPessoa = 6L; //código que quero pesquisar
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("125");
		funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2020"));
		funcionario.setPessoa(pessoa);
		
		if(pessoa == null){
			System.out.println("Pessoa não está cadastrada!");
		} else {
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionario);
			
			System.out.println("Funcionario cadastrado com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();
		
		System.out.println("Total de "+ "'"+resultado.size()+"'"+" registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Funcionario funcionario : resultado) {	
			System.out.println("Id: "+funcionario.getCodigo());
			System.out.println("CTPS: "+funcionario.getCarteiraTrabalho());
			System.out.println("Nome do Funcionario: "+funcionario.getPessoa().getNome());
			System.out.println();
			
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L; //código que quero pesquisar
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if(funcionario == null) {
			System.out.println("Objeto não encontrado");			
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Id funcionario: "+funcionario.getCodigo());
			System.out.println("Nome Pessoa: "+funcionario.getPessoa().getCodigo()+"-"+funcionario.getPessoa().getNome());
			System.out.println("CTPS: "+funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: "+funcionario.getDataAdmissao());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L; //código que quero pesquisar
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if(funcionario == null) {
			System.out.println("Objeto não encontrado!");
			//JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Objeto excluído com sucesso!");
			//JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoFuncionario = 1L; //código do funcionario que quero pesquisar
		Long codigoPessoa = 2L; ///código da pessoa que quero pesquisar
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if (funcionario == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			funcionario.setCarteiraTrabalho("20005");
			funcionario.setDataAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("30/09/2020"));
			funcionario.setPessoa(pessoa);
			
			funcionarioDAO.editar(funcionario);

			System.out.println("Id funcionario: "+funcionario.getCodigo());
			System.out.println("Nome Pessoa: "+funcionario.getPessoa().getCodigo()+"-"+funcionario.getPessoa().getNome());
			System.out.println("CTPS: "+funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissão: "+funcionario.getDataAdmissao());
			System.out.println();
		}
	}
}