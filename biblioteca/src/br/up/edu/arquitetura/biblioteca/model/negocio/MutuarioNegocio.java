package br.up.edu.arquitetura.biblioteca.model.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.model.persistencia.MutuarioPersistencia;

public class MutuarioNegocio {

	private MutuarioPersistencia persist = new MutuarioPersistencia();

	public ArrayList<Mutuario> listarTodos() {
		System.out.println("lista");
		return persist.list();
	}

	public Mutuario find(String nome) {

		return persist.find(nome);
	}

	public Mutuario salvar(Mutuario mutuario) {

		if (mutuario.getId() != 0) {
			System.out.println("aqui mutuario update");
			return persist.update(mutuario);

		} else {
			System.out.println("aqui mutuario insert ");
			return persist.insert(mutuario);
		}
	}

	public Mutuario findId(int id) {
		return persist.findId(id);
	}
}
