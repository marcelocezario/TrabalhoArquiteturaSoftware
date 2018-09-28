package br.up.edu.arquitetura.biblioteca.model.dominio;

public class Mutuario {
	
	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;
	private Integer qtdeLivro;
	
	public Mutuario(){}
	
	public Mutuario(String nome, String endereco, String telefone){
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdeLivro() {
		return qtdeLivro;
	}

	public void setQtdeLivro(Integer qtdeLivro) {
		this.qtdeLivro = qtdeLivro;
	}

	
	
}
