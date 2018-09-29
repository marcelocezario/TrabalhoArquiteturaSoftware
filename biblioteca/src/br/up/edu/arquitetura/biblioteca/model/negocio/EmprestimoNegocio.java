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
			novoEmprestimo(emprestimo);

			return persist.insert(emprestimo);
		}
		if (emprestimo.getDataDevolucao() != null) {
			devolverEmprestimo(emprestimo);

			return persist.update(emprestimo);
		} else {
			renovarEmprestimo(emprestimo);

			return persist.update(emprestimo);
		}
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
		lvnegocio.alterarStatus(emprestimo.getLivro().getId());
		mnegocio.adicionarEmprestimo(emprestimo.getMutuario().getId());
	}

	private void devolverEmprestimo(Emprestimo emprestimo) {

		emprestimo.setDataDevolucao(converteData(emprestimo.getDataDevolucao().toString()));
		lvnegocio.alterarStatus(emprestimo.getLivro().getId());
//		mnegocio.subtrairEmprestimo(emprestimo.getMutuario().getId());
	}

	private void renovarEmprestimo(Emprestimo emprestimo) {

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

		if (emprestimo.getId() == null)
			novoEmprestimo = true;
		else
			novoEmprestimo = false;

		if (validaMutuario(emprestimo.getMutuario().getId(), novoEmprestimo)) {
			if (validaLivro(emprestimo.getLivro().getId(), novoEmprestimo)) {
				return true;
			}
		}

		return false;
	}

	private boolean validaLivro(int idLivro, boolean novoEmprestimo) {
		/*
		 * Livro livro = lvnegocio.findId(idLivro);
		 * 
		 * if (livro.isStatus()) return false; else if (novoEmprestimo) return false;
		 */ return true;
	}

	private boolean validaMutuario(int idMutuario, boolean novoEmprestimo) {

		/*
		 * Mutuario mutuario = mnegocio.findId(idMutuario);
		 * 
		 * int nrMaxEmprPorMutuario = 1;
		 * 
		 * if (mutuario.getQtdeEmprestimoAtivos() < nrMaxEmprPorMutuario) { return true;
		 * } else if (mutuario.getQtdeEmprestimoAtivos() == nrMaxEmprPorMutuario &&
		 * novoEmprestimo == false) { return true; }
		 * 
		 * return false;
		 */
		return true;

	}

}
