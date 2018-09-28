package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;

public class EmprestimoPersistencia {
	
	private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private LivroPersistencia lvpersist = new LivroPersistencia();
	private MutuarioPersistencia mpersist = new MutuarioPersistencia();
	
	public Emprestimo insert(Emprestimo emprestimo) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataAtual = sdf.parse(LocalDate.now().toString());
			
			emprestimo.setDataEmprestimo(dataAtual);
			System.out.println(emprestimo.getDataEmprestimo());
			System.out.println(emprestimo.getDataPrevistaDevolucao());
			emprestimo.setMutuario(mpersist.findId(emprestimo.getMutuario().getId()));
			emprestimo.setId(emprestimos.size());
			emprestimo.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));
			emprestimos.add(emprestimo);
			
			return emprestimos.get(emprestimo.getId());
		} catch (ParseException e) {
			 e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Emprestimo> list(){
		
		ArrayList<Emprestimo> aDevolver = new ArrayList<Emprestimo>();
		
		for (Emprestimo emprestimo : emprestimos) {
			if(emprestimo.getDataDevolucao() == null){
				aDevolver.add(emprestimo);
			}
		}
		return aDevolver;
	}
	
	public Emprestimo devolucso (Emprestimo emprestimo) {
		
		Emprestimo aux = emprestimos.get(emprestimo.getId());
		aux.setId(emprestimo.getId());
		aux.setDataDevolucao(emprestimo.getDataDevolucao());
		aux.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));
		
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
