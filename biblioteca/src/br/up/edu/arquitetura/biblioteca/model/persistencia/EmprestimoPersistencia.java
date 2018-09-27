package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;

public class EmprestimoPersistencia {
	
	private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private LivroPersistencia lvpersist = new LivroPersistencia();
	private MutuarioPersistencia mpersist = new MutuarioPersistencia();
	
	public Emprestimo insert(Emprestimo emprestimo) {
		
		emprestimo.setLivro(lvpersist.findId(emprestimo.getLivro().getId()));
		emprestimo.setMutuario(mpersist.findId(emprestimo.getMutuario().getId()));
	
		emprestimo.setId(emprestimos.size());
		emprestimo.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));
		emprestimos.add(emprestimo);
		
		return emprestimos.get(emprestimo.getId());
	}
	
	public ArrayList<Emprestimo> list(){
		return emprestimos;
	}
	
	public Emprestimo update (Emprestimo emprestimo) {
		
		Emprestimo aux = emprestimos.get(emprestimo.getId());
		aux.setId(emprestimo.getId());
		aux.setDataPrevistaDevolucao(emprestimo.getDataEmprestimo());
		aux.setLivro(emprestimo.getLivro());
		
		return aux;
	}
	
	public Emprestimo find (String data) {
		Emprestimo emprestimoRetorno = null;
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDataEmprestimo().equals(data)) {
				emprestimoRetorno = emprestimo;
			}
		}
		return emprestimoRetorno;
	}
	
	public Emprestimo findId(int id) {
		return emprestimos.get(id);	
	}

	public boolean verificaLivro(Emprestimo emprestimo) {
		if(lvpersist.findId(emprestimo.getLivro().getId()).isStatus()){
			return false;
		}
		return true;

	}
}
