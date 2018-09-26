package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;

public class LivroPersistencia {
	
	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	
	public Livro insert(Livro livro) {
		
		//salvar no array
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
	
	public Livro alterarStatus(int id) {
		Livro aux = livros.get(id);
		if(aux.isStatus()){			
			aux.setStatus(false);
		}else{
			aux.setStatus(true);
		}		
		return aux;
	}
}
