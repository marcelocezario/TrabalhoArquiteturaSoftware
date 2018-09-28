package br.up.edu.arquitetura.biblioteca.model.dominio;

import java.time.LocalDate;
import java.util.Date;

public class Emprestimo {

	private Integer id;
	private Livro livro;
	private Mutuario mutuario;
	private Date dataEmprestimo ;
	private Date dataPrevistaDevolucao;
	private Date dataDevolucao;

	public Emprestimo() {
	}

	public Emprestimo(Date dataEmprestimo, Date dataPrevistaDevolucao, Livro livro, Mutuario mutuario) {
		this.dataEmprestimo = dataEmprestimo;
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		this.livro = livro;
		this.mutuario = mutuario;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	

}
