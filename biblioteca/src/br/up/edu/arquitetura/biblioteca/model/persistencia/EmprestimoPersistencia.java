package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;import org.omg.CORBA.PERSIST_STORE;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;

public class EmprestimoPersistencia {
	
	private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private LivroPersistencia lvpersist = new LivroPersistencia();
	private MutuarioPersistencia mpersist = new MutuarioPersistencia();
	
	public Emprestimo insert(Emprestimo emprestimo) {
		
		emprestimo.setId(emprestimos.size());
		emprestimo.setLivro(lvpersist.findId(emprestimo.getLivro().getId()));
		emprestimo.setMutuario(mpersist.findId(emprestimo.getMutuario().getId()));
		emprestimo.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));
		emprestimos.add(emprestimo);
		
		return emprestimos.get(emprestimo.getId());
	}
	
	public ArrayList<Emprestimo> list(){
		return emprestimos;
	}
	
	public Emprestimo update (Emprestimo emprestimo) {
		
		Emprestimo aux = findId(emprestimo.getId());
		aux.setDataEmprestimo(emprestimo.getDataEmprestimo());
		aux.setDataPrevistaDevolucao(emprestimo.getDataPrevistaDevolucao());
		aux.setDataDevolucao(emprestimo.getDataDevolucao());
		aux.setLivro(lvpersist.findId(emprestimo.getLivro().getId()));
		aux.setMutuario(mpersist.findId(emprestimo.getLivro().getId()));
		
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
	
	public ArrayList<Emprestimo> listarEmprestimosPendentesPorMutuario (Mutuario mutuario) {
		ArrayList<Emprestimo> emprestimosMutuario = new ArrayList<Emprestimo>();
		
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getMutuario().getId().equals(mutuario.getId()) && emprestimo.getDataDevolucao() == null);
			emprestimosMutuario.add(emprestimo);
		}
		
		return emprestimosMutuario;
		
	}

}
