package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;
import br.up.edu.arquitetura.biblioteca.model.dominio.Autor;

public class AutorPersistencia  {
	
	private static ArrayList<Autor> autores = new ArrayList<Autor>();
	private static int id;
	
	public Autor insert(Autor autor) {
		//salvar no array
		autor.setId(autores.size() + 1);
		autores.add(autor);
		
		return autores.get(autor.getId());
	}
	
	public ArrayList<Autor> list(){
		return autores;
	}
	
	public Autor update (Autor autor) {
		Autor aux = autores.get(autor.getId());
		aux.setId(autor.getId());
		aux.setNacionalidade(autor.getNacionalidade());
		aux.setNome(autor.getNome());
		
		return aux;
	}

	public Autor find (String nome) {
		Autor autorRetorno = null;
		for (Autor autor : autores) {
			if (autor.getNome().equals(nome)) {
				autorRetorno = autor;
			}
		}
		return autorRetorno;
	}
	
	public Autor findId(int id) {
		return autores.get(id);	

	}
}
