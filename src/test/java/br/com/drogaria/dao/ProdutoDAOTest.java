package br.com.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigoFabricante = 3L; // Cadastrar produto com o id do fabricante

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		Produto produto = new Produto();
		produto.setDescricao("Indosso 150mg, caixa com 1 comprimidos revestido");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("41.65"));
		produto.setQuantidade(new Short("10"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
		System.out.println("Produto cadastrado com sucesso!");

	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		System.out.println("Total de " + "'" + resultado.size() + "'" + " registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Produto produto : resultado) {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("==========================================================");
			System.out.println("Id: " + produto.getCodigo());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Qtd: " + produto.getQuantidade());
			System.out.println("Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 4L; // código que quero pesquisar

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Produto não cadastrado!");
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("==========================================================");
			System.out.println("Id: " + produto.getCodigo());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Qtd: " + produto.getQuantidade());
			System.out.println("Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 5L; // código que quero pesquisar
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Produto não existe!");
			// JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Produto excluído com sucesso!");
			// JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoProduto = 6L; // código da produto que quero editar
		Long codidoFabricante = 7L; // códido do estado que quero editar

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codidoFabricante);

		if (produto == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			System.out.println("REGISTRO ANTERIOR:");
			System.out.println("Código: " + produto.getCodigo());
			System.out.println("Descrição: " + produto.getDescricao());
			System.out.println("Qtd: " + produto.getQuantidade());
			System.out.println("Preço: " + produto.getPreco());

			if (fabricante == null) {
				System.out.println("Objeto não encontrado!");
			} else {
				// EDITAR PRODUTO AQUI ===========================>>>>>
				produto.setDescricao("ACECLOFENACO");
				produto.setFabricante(fabricante);
				produto.setPreco(new BigDecimal("25.80"));
				produto.setQuantidade(new Short("30"));

				produtoDAO.editar(produto);
				System.out.println();
				System.out.println("REGISTRO ATUAL:");
				System.out.println("Código: " + produto.getCodigo());
				System.out.println("Descrição: " + produto.getDescricao());
				System.out.println("Qtd: " + produto.getQuantidade());
				System.out.println("Preço: " + produto.getPreco());
			}
		}
	}
}
