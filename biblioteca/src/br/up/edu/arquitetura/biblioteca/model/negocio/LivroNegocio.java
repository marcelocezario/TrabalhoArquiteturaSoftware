package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.persistencia.LivroPersistencia;
import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;;

public class LivroNegocio {

	private LivroPersistencia persist = new LivroPersistencia();
	private AutorNegocio autorBC = new AutorNegocio();

	public void load() {
		autorBC.load();
		Autor jv = autorBC.find("Julio Verne");
		Autor jrrt = autorBC.find("J.R.R Tolkien");
		System.out.println("load lirvro " + jv.getNome());
		salvar(new Livro("Viagem ao Centro da Terra", 200, "A hist����ria de jovens que viajam ao centro da terra.", jv,
				false));
		salvar(new Livro("A Volta ao Mundo em 80 dias", 320, "Uma competi��������o ao redor do mundo", jv, false));
		salvar(new Livro("O Hobbit", 295,
				"Pequenos seres de p����s peludos ajudando an����es a enfrentar um drag����o.", jrrt, false));
		salvar(new Livro("O Senhor dos An����is", 1200, "Uma jornada ����pica contra o mal.", jrrt, false));

	}

	public ArrayList<Livro> listarTodos() {
		System.out.println("lista");
		return persist.list();
	}

	public Livro find(String titulo) {

		return persist.find(titulo);
	}

	public Livro salvar(Livro livro) {

		if (livro.getId() != 0) {
			System.out.println("aqui livro update");
			System.out.println(livro.getAutor().getNome());
			return persist.update(livro);

		} else {
			System.out.println("aqui livro insert ");
			return persist.insert(livro);

		}
	}

	public Livro findId(int id) {
		return persist.findId(id);
	}
}
