package br.up.edu.arquitetura.biblioteca.model.dominio;

import java.util.Date;

public class Emprestimo {

	private Integer id;
	private Livro livro;
	private Mutuario mutuario;
	private String dataEmprestimo;
	private String dataPrevistaDevolucao;
	private String dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(String dataEmprestimo, String dataPrevistaDevolucao, String dataDevolucao, Livro livro, Mutuario mutuario) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.dataDevolucao = dataDevolucao;
		this.livro = livro;
		this.mutuario = mutuario;
	}

	public Integer getId() {
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
	
	public Mutuario getMutuario() {
		return mutuario;
	}

	public void setMutuario(Mutuario mutuario) {
		this.mutuario = mutuario;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(String dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	

}
