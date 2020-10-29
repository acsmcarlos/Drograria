package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Fabricante 05");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de "+ "'"+resultado.size()+"'"+" registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Fabricante fabricante : resultado) {	
			System.out.println("Id: "+fabricante.getCodigo()+"-"+ fabricante.getDescricao());
			
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L; //código que quero pesquisar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if(fabricante == null) {
			System.out.println("Objeto não encontrado");			
		} else {
			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Id: "+fabricante.getCodigo()+" "+ fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 4L; //código que quero pesquisar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if(fabricante == null) {
			System.out.println("Objeto não encontrado!");
			//JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Objeto excluído com sucesso!");
			//JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 2L; //código que quero pesquisar
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if(fabricante == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			System.out.println("Registro anterior:");
			System.out.println(fabricante.getCodigo()+"-"+fabricante.getDescricao());

			fabricante.setDescricao("Mantecorp");
			fabricanteDAO.editar(fabricante);

			System.out.println("Objeto atual:");
			System.out.println(fabricante.getCodigo()+"-"+ fabricante.getDescricao());
		}
	}
}
