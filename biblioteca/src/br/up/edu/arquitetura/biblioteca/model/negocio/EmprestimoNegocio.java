package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.up.edu.arquitetura.biblioteca.model.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.model.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.persistencia.EmprestimoPersistencia;
import br.up.edu.arquitetura.biblioteca.model.persistencia.LivroPersistencia;
import br.up.edu.arquitetura.biblioteca.model.persistencia.MutuarioPersistencia;;

public class EmprestimoNegocio {

	private EmprestimoPersistencia persist = new EmprestimoPersistencia();
	private LivroNegocio lvnegocio = new LivroNegocio();
	private MutuarioNegocio mnegocio = new MutuarioNegocio();

	public Emprestimo salvar(Emprestimo emprestimo) throws Exception {

		if (emprestimo.getId() == null) {
			if (novoEmprestimo(emprestimo))
				return persist.insert(emprestimo);
		}
		if (emprestimo.getDataDevolucao() != null) {

			devolverEmprestimo(emprestimo);
			lvnegocio.alterarStatus(emprestimo.getLivro().getId());
			mnegocio.subtrairEmprestimo(emprestimo.getMutuario().getId());

			return persist.update(emprestimo);

		} else {

			editarEmprestimo(emprestimo);

			return persist.update(emprestimo);
		}
	}

	public Emprestimo findId(int id) {
		return persist.findId(id);
	}

	public List<Emprestimo> listarTodos() {
		return persist.list();
	}

	private boolean novoEmprestimo(Emprestimo emprestimo) {

		if (validaLivro(emprestimo.getLivro().getId())) {
			emprestimo.setDataEmprestimo(converteData(LocalDate.now().toString()));
			emprestimo.setDataPrevistaDevolucao(converteData(emprestimo.getDataPrevistaDevolucao().toString()));
			alterarStatusLivro(emprestimo.getLivro().getId());
			
			return true;
		}
		return false;
	}

	private void devolverEmprestimo(Emprestimo emprestimo) {

		emprestimo.setDataDevolucao(converteData(emprestimo.getDataDevolucao().toString()));
		alterarStatusLivro(emprestimo.getLivro().getId());
	}

	private void editarEmprestimo(Emprestimo emprestimo) {

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

		return true;

//		if (validaMutuario(emprestimo.getMutuario())) {
//			if (validaLivro(emprestimo.getLivro())) {
//				return true;
//			}
//		}
//
//		return false;
	}

	private boolean validaLivro(int idLivro) {

		return lvnegocio.validaLivro(idLivro);

	}

	private void alterarStatusLivro(int idLivro) {

		lvnegocio.alterarStatus(idLivro);
	}

//	private boolean validaMutuario(Mutuario mutuario) {
//		
//		int nrMaxEmprPorMutuario = 1;
//		
//		if (mutuario.getQtdeEmprestimoAtivos() <= nrMaxEmprPorMutuario) {
//			return true;
//		}
//		
//		return false;
//	}

}
