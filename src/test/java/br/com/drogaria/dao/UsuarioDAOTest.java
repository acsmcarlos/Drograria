package br.com.drogaria.dao;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Pessoa;
import br.com.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		Long codigoPessoa = 3L; // código que quero pesquisar

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("12345");
		usuario.setTipo('A');

		if (pessoa == null) {
			System.out.println("Pessoa não está cadastrada!");
		} else {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);

			System.out.println("Usuario cadastrado com sucesso!");
		}
	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		System.out.println("Total de " + "'" + resultado.size() + "'" + " registros encontrados no Banco de Dados.");
		System.out.println("------------------------------------------");
		for (Usuario usuario : resultado) {
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Nome: " + usuario.getPessoa().getNome());

			System.out.println();

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L; // código que quero pesquisar
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Objeto não encontrado");
		} else {
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Nome: " + usuario.getPessoa().getNome());

			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L; // código que quero pesquisar
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Objeto não encontrado!");
			// JOptionPane.showMessageDialog(null, "Objeto não encontrado!");
		} else {
			usuarioDAO.excluir(usuario);
			System.out.println("Objeto excluído com sucesso!");
			// JOptionPane.showMessageDialog(null, "Objeto excluído com sucesso!");
		}
	}

	@Test
	@Ignore
	public void editar() throws ParseException {
		Long codigoUsuario = 2L; // código do usuario que quero pesquisar
		Long codigoPessoa = 5L; /// código da pessoa que quero pesquisar

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigoUsuario);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);

		if (usuario == null) {
			System.out.println("Objeto não encontrado!");
		} else {
			usuario.setAtivo(false);
			usuario.setSenha("22222");
			usuario.setTipo('B');
			usuario.setPessoa(pessoa);

			usuarioDAO.editar(usuario);

			System.out.println("RESULTADO DA BUSCA");
			System.out.println("Codigo: " + usuario.getCodigo());
			System.out.println("Ativo: " + usuario.getAtivo());
			System.out.println("Tipo: " + usuario.getTipo());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Nome: " + usuario.getPessoa().getNome());
		}
	}
}