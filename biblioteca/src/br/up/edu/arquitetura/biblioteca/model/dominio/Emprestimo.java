package br.up.edu.arquitetura.biblioteca.model.dominio;

public class Emprestimo {

	private int id;
	private Livro livro;
	private Mutuario mutuario;
	private String dataEmprestimo;
	private String dataPrevistaDevolucao;
	private String dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(String dataEmprestimo, String dataDevolucao, Livro livro, Mutuario mutuario) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.livro = livro;
		this.mutuario = mutuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Mutuario getMutuario() {
		return mutuario;
	}

	public void setMutuario(Mutuario mutuario) {
		this.mutuario = mutuario;
	}
	

}
