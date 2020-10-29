package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoCliente = 4L; // código que quero pesquisar
		Long codigoFuncionario = 4L; // código que quero pesquisar

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		Venda venda = new Venda();
		venda.setHorario(new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2020"));
		venda.setValorTotal(new BigDecimal("10.50"));
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);

		if (cliente == null) {
			System.out.println("Pessoa não está cadastrada!");
		} else {
			VendaDAO vendaDAO = new VendaDAO();
			vendaDAO.salvar(venda);

			System.out.println("Venda cadastrado com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();

		System.out.println("Total de " + "'" + resultado.size() + "'" + " registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Venda venda : resultado) {
			System.out.println("Id: " + venda.getCodigo());
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println(
					"Id Cliente :" + venda.getCliente().getCodigo() + "-" + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario: " + venda.getFuncionario().getCodigo() + "-"
					+ venda.getFuncionario().getPessoa().getNome());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 5L; // código que quero pesquisar
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Objeto não encontrado");
		} else {
			System.out.println("Id: " + venda.getCodigo());
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println(
					"Id Cliente :" + venda.getCliente().getCodigo() + "-" + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario: " + venda.getFuncionario().getCodigo() + "-"
					+ venda.getFuncionario().getPessoa().getNome());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L; // código que quero pesquisar
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Objeto não encontrado!");
			// JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			vendaDAO.excluir(venda);
			System.out.println("Objeto excluído com sucesso!");
			// JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoVenda = 5L; // código que quero pesquisar
		Long codigoCliente = 3L; // código que quero pesquisar
		Long codigoFuncionario = 2L; // código que quero pesquisar

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);

		if (venda == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			venda.setHorario(new SimpleDateFormat("dd/MM/yyyy").parse("19/08/2020"));
			venda.setValorTotal(new BigDecimal("10.50"));
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);

			vendaDAO.editar(venda);

			System.out.println("Id: " + venda.getCodigo());
			System.out.println("Horário: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println(
					"Id Cliente :" + venda.getCliente().getCodigo() + "-" + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario: " + venda.getFuncionario().getCodigo() + "-"
					+ venda.getFuncionario().getPessoa().getNome());
			System.out.println();
		}
	}
}