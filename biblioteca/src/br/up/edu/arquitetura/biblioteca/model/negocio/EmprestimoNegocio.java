package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.persistencia.EmprestimoPersistencia;;

public class EmprestimoNegocio {

	private EmprestimoPersistencia persist = new EmprestimoPersistencia();

	public Emprestimo salvar(Emprestimo emprestimo) {

		if (emprestimo.getId() == null) {
			if (persist.verificaLivro(emprestimo)) {
				return emprestimo;
			}
		} else {
			return persist.devolucao(emprestimo);
		}
		return null;
	}

	public Emprestimo findId(int id) {
		return persist.findId(id);
	}

	public List<Emprestimo> listarTodos() {
		return persist.list();
	}

	public void devolverEmprestimo() {

	}
}
