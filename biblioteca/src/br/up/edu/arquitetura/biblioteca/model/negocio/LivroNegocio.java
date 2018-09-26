package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.persistencia.LivroPersistencia;
import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;;

public class LivroNegocio {

	private LivroPersistencia persist = new LivroPersistencia();
	private AutorNegocio autorBC = new AutorNegocio();

	
	public ArrayList<Livro> listarTodos() {
		System.out.println("lista");
		return persist.list();
	}

	public Livro find(String titulo) {

		return persist.find(titulo);
	}

	public Livro salvar(Livro livro) {

		if (livro.getId() == null) {
			return persist.insert(livro);
		} else {
			return persist.update(livro);
		}
	}

	public Livro findId(int id) {
		return persist.findId(id);
	}
	
	public void load() {
		//Não mexa aqui !!!!!!!!!!!!!!
		//Não altere tb
		
		/*
		 * GABRYEL, porque mexeu aqui?
		 * Não estava adicionando autor, mas agora além de não adicionar autor ta dando erro ao salvar 
		 * Responda de algum jeito, teu whats não chegas as mensagens
		 * Agora eu tava mexendo nessa parte começou a dar problema
		 * 
		 * 
		 */
		Autor jv = autorBC.find("Julio Verme");
		Autor lu = autorBC.find("luiz");

		if (listarTodos().size() == 0) {
			salvar(new Livro("Testando 1", 200, "Apenas um teste", jv , false));
			salvar(new Livro("Testando 2", 400, "Esse é outro teste", lu , false));
		}
	}
}
