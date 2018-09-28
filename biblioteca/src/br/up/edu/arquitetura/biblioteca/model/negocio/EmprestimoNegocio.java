package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.persistencia.EmprestimoPersistencia;;

public class EmprestimoNegocio {

	private EmprestimoPersistencia persist = new EmprestimoPersistencia();

	public Emprestimo salvar(Emprestimo emprestimo) throws Exception {
		
		if(validaEmprestimo(emprestimo)) {
			if (emprestimo.getId() == null) {
				
				novoEmprestimo(emprestimo);
				
				return persist.insert(emprestimo);
			} if (emprestimo.getDataDevolucao() != null){
				
				devolverEmprestimo(emprestimo);
				
				return persist.update(emprestimo);

			} else {
				
				editarEmprestimo(emprestimo);
				
				return persist.update(emprestimo);
			}
		}
		
		throw new Exception ("Emprestimo nao realizado, mutuario ou livro nao disponivel");
	}

	public Emprestimo findId(int id) {
		return persist.findId(id);
	}

	public List<Emprestimo> listarTodos() {
		return persist.list();
	}
	
	private void novoEmprestimo(Emprestimo emprestimo) {

		emprestimo.setDataEmprestimo(converteData(LocalDate.now().toString()));
		emprestimo.setDataPrevistaDevolucao(converteData(emprestimo.getDataPrevistaDevolucao().toString()));
	}
	
	private void devolverEmprestimo(Emprestimo emprestimo){
		
		emprestimo.setDataDevolucao(converteData(emprestimo.getDataDevolucao().toString()));
	}
	
	private void editarEmprestimo(Emprestimo emprestimo) {

		emprestimo.setDataEmprestimo(converteData(emprestimo.getDataEmprestimo().toString()));
		emprestimo.setDataPrevistaDevolucao(converteData(emprestimo.getDataPrevistaDevolucao().toString()));
	}
	
	protected String converteData(String string) {

		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

		try {
			String result = out.format(in.parse(string));
			return result;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	private boolean validaEmprestimo(Emprestimo emprestimo) {
		
		boolean novoEmprestimo;
		
		if (emprestimo.getId() == null) {
			novoEmprestimo = true;
		} else {
			novoEmprestimo = false;
		}
		
		if (validaMutuario(emprestimo.getMutuario(), novoEmprestimo)) {
			if (validaLivro (emprestimo.getLivro())) {
				return true;
			}
		}

		return false;
	}

	private boolean validaLivro(Livro livro) {
		
		return true;
	}

	private boolean validaMutuario(Mutuario mutuario, boolean novoEmprestimo) {
		
		ArrayList<Emprestimo> emprestimosMutuario = persist.listarEmprestimosPendentesPorMutuario(mutuario);
		
		for (Emprestimo emprestimo : emprestimosMutuario) {
			System.out.println(emprestimo.getLivro());
			
		}
		
		if (emprestimosMutuario.size() == 0) {
			return true;
		} if (emprestimosMutuario.size() == 1 && novoEmprestimo == false) {
			return true;
		}
		return false;
	}
	
}
