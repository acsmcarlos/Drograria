package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.ItemVenda;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoProduto = 3L; // Cadastrar item com o id do fabricante
		Long codigoVenda = 5L; // Cadastrar item com o id do fabricante

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		ItemVenda itemvenda = new ItemVenda();
		itemvenda.setQuantidade(new Short("3"));
		itemvenda.setValorParcial(new BigDecimal("25.58"));
		itemvenda.setProduto(produto);
		itemvenda.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(itemvenda);
		System.out.println("Item cadastrado com sucesso!");

	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<ItemVenda> resultado = itemDAO.listar();

		System.out.println("Total de " + "'" + resultado.size() + "'" + " registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (ItemVenda item : resultado) {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("==========================================================");
			System.out.println("Id: " + item.getCodigo());
			System.out.println("Qtd: " + item.getQuantidade());
			System.out.println("Preço: " + item.getValorParcial());
			System.out.println("Produto: " + item.getProduto().getDescricao());
			System.out.println("Venda: " + item.getVenda().getCodigo());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L; // código que quero pesquisar

		ItemDAO itemDAO = new ItemDAO();
		ItemVenda item = itemDAO.buscar(codigo);

		if (item == null) {
			System.out.println("Item não cadastrado!");
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("==========================================================");
			System.out.println("Id: " + item.getCodigo());
			System.out.println("Qtd: " + item.getQuantidade());
			System.out.println("Preço: " + item.getValorParcial());
			System.out.println("Produto: " + item.getProduto().getDescricao());
			System.out.println("Venda: " + item.getVenda().getCodigo());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L; // código que quero pesquisar
		ItemDAO itemDAO = new ItemDAO();
		ItemVenda item = itemDAO.buscar(codigo);

		if (item == null) {
			System.out.println("Item não existe!");
			// JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			itemDAO.excluir(item);
			System.out.println("Item excluído com sucesso!");
			// JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoItem = 2L;
		Long codigoProduto = 1L;
		Long codigoVenda = 6L;

		ItemDAO itemDAO = new ItemDAO();
		ItemVenda item = itemDAO.buscar(codigoItem);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigoVenda);

		System.out.println("RESULTADO ANTERIOR");
		System.out.println("==========================================================");
		System.out.println("Id: " + item.getCodigo());
		System.out.println("Qtd: " + item.getQuantidade());
		System.out.println("Preço: " + item.getValorParcial());
		System.out.println("Produto: " + item.getProduto().getCodigo());
		System.out.println("Venda: " + item.getVenda().getCodigo());
		System.out.println();

		item.setQuantidade(new Short("9"));
		item.setValorParcial(new BigDecimal("18.30"));
		item.setProduto(produto);
		item.setVenda(venda);

		itemDAO.editar(item);

		System.out.println("RESULTADO ATUAL");
		System.out.println("==========================================================");
		System.out.println("Id: " + item.getCodigo());
		System.out.println("Qtd: " + item.getQuantidade());
		System.out.println("Preço: " + item.getValorParcial());
		System.out.println("Produto: " + item.getProduto().getCodigo());
		System.out.println("Venda: " + item.getVenda().getCodigo());
		System.out.println();

	}
}
