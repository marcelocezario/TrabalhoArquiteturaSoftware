package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.persistencia.EmprestimoPersistencia;;

public class EmprestimoNegocio {

	private EmprestimoPersistencia persist = new EmprestimoPersistencia();

	public Emprestimo salvar(Emprestimo emprestimo) {
		
		if (emprestimo.getId() != 0) {
			System.out.println("aqui emprestimo update");
			return persist.update(emprestimo);
		} else if (persist.verificaLivro(emprestimo)) {
			if (persist.insert(emprestimo) != null) {
				System.out.println("aqui emprestimo insert ");
				return emprestimo;
			} else {
				return null;
			}
		}
		return null;
	}

	public Emprestimo findId(int id) {
		return persist.findId(id);
	}

	public List<Emprestimo> listarTodos() {
		return persist.list();
	}
	
	public void devolverEmprestimo(){
		
	}
}
