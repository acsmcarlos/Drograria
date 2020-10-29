package br.com.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoPessoa = 6L; //código que quero pesquisar
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2020"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		if(pessoa == null){
			System.out.println("Pessoa não está cadastrada!");
		} else {
			ClienteDAO clienteDAO = new ClienteDAO();
			clienteDAO.salvar(cliente);
			
			System.out.println("Cliente cadastrado com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();
		
		System.out.println("Total de "+ "'"+resultado.size()+"'"+" registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Cliente cliente : resultado) {	
			System.out.println("Id: "+cliente.getCodigo());
			System.out.println("Data: "+cliente.getDataCadastro());
			System.out.println("Ativo: "+cliente.getLiberado());
			System.out.println("Nome do Cliente: "+cliente.getPessoa().getNome());
			System.out.println();
			
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L; //código que quero pesquisar
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if(cliente == null) {
			System.out.println("Objeto não encontrado");			
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Id: "+cliente.getCodigo());
			System.out.println("Data: "+cliente.getDataCadastro());
			System.out.println("Ativo: "+cliente.getLiberado());
			System.out.println("Nome do Cliente: "+cliente.getPessoa().getNome());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L; //código que quero pesquisar
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if(cliente == null) {
			System.out.println("Objeto não encontrado!");
			//JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Objeto excluído com sucesso!");
			//JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoCliente = 1L; //código do cliente que quero pesquisar
		Long codigoPessoa = 2L; ///código da pessoa que quero pesquisar
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if(cliente == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("18/07/2020"));
			cliente.setLiberado(false);
			cliente.setPessoa(pessoa);
			
			clienteDAO.editar(cliente);

			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Id: "+cliente.getCodigo());
			System.out.println("Data: "+cliente.getDataCadastro());
			System.out.println("Ativo: "+cliente.getLiberado());
			System.out.println("Nome do Cliente: "+cliente.getPessoa().getNome());
			System.out.println();
		}
	}
}