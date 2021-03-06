package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;

public class LivroPersistencia {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	private AutorPersistencia persist = new AutorPersistencia();
	
	public Livro insert(Livro livro) {
		//salvar no array
		
		livro.setAutor(persist.findId(livro.getAutor().getId()));

		livro.setId(livros.size());
		livros.add(livro);
		
		return livros.get(livro.getId());
	}
	
	public ArrayList<Livro> list(){
		return livros;
	}
	
	public Livro update (Livro livro) {
		
		Livro aux = findId(livro.getId());
		aux.setTitulo(livro.getTitulo());
		aux.setPaginas(livro.getPaginas());
		aux.setResumo(livro.getResumo());
		aux.setTitulo(livro.getTitulo());
		aux.setAutor(persist.findId(livro.getAutor().getId()));
		
		return aux;
	}
	
	public Livro find (String titulo) {
		Livro livroRetorno = null;
		for (Livro livro : livros) {
			if (livro.getTitulo().equals(titulo)) {
				livroRetorno = livro;
			}
		}
		return livroRetorno;
	}
	
	public Livro findId(int id) {
		return livros.get(id);	
	}
	
	public void alterarStatus(int id) {
		Livro livro = livros.get(id);
		if(livro.isStatus()){			
			livro.setStatus(false);
		}else{
			livro.setStatus(true);
		}		
	}
}
