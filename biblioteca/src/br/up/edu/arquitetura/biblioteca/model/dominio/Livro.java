package br.up.edu.arquitetura.biblioteca.model.dominio;

public class Livro {

	private Integer id;
	private String titulo;
	private Integer paginas;
	private String resumo;
	private Autor autor;
	private boolean status = false;

	public Livro() {

	}

	public Livro(String titulo, Integer paginas, String resumo, Autor autor, boolean status) {
		this.titulo = titulo;
		this.paginas = paginas;
		this.resumo = resumo;
		this.autor = autor;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
