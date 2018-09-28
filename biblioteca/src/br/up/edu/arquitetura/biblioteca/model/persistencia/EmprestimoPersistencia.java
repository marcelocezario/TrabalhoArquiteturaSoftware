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
	private MutuarioPersistencia mPersist = new MutuarioPersistencia();

	public Emprestimo insert(Emprestimo emprestimo) {

		emprestimo.setId(emprestimos.size());
		// seta a data do sistema, não faz senido o usuario setar isso
		emprestimo.setDataEmprestimo(converteData(LocalDate.now().toString()));
		emprestimo.setDataPrevistaDevolucao(converteData(emprestimo.getDataPrevistaDevolucao()));

		emprestimo.setMutuario(mPersist.findId(emprestimo.getMutuario().getId()));
		emprestimo.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));
		emprestimos.add(emprestimo);

		return emprestimos.get(emprestimo.getId());

	}

	public ArrayList<Emprestimo> list() {
		ArrayList<Emprestimo> emprestados = new ArrayList<>();
		for (Emprestimo emprestimo : emprestimos) {
			if (emprestimo.getDataDevolucao() == null) {
				emprestados.add(emprestimo);
			}
		}
		return emprestados;
	}

	public Emprestimo devolucao(Emprestimo emprestimo) {

		System.out.println("devolvel o livro huehuehuehuehue");
		Emprestimo aux = emprestimos.get(emprestimo.getId());
		aux.setId(emprestimo.getId());
		aux.setDataDevolucao(converteData(emprestimo.getDataDevolucao()));
		aux.setLivro(lvpersist.alterarStatus(emprestimo.getLivro().getId()));

		return aux;
	}

	public Emprestimo find(String data) {

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
		if (lvpersist.findId(emprestimo.getLivro().getId()).isStatus()) {
			return false;
		}
		return true;

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

	public boolean validaMutuario(Emprestimo emprestimo) {

		if (mPersist.qtdeLivroMutuario(emprestimo.getMutuario()).getQtdeLivro() == 1) {
			return false;
		}
		return true;
	}
}
