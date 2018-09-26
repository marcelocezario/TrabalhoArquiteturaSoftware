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

		if (mutuario.getId() != null) {
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

	public void load() {
		
		if (listarTodos().size() == 0) {
			Mutuario mutuario = new Mutuario("luiz", "Av. iguaçu, 1200", "4578894616");
			Mutuario mutuario1 = new Mutuario("João", "Av. iguaçu,1 1200", "4578894616");
			Mutuario mutuario2 = new Mutuario("Mercedes", "Av. iguaçu, 1 1200", "4578894616");

			salvar(mutuario);
			salvar(mutuario1);
			salvar(mutuario2);
		}
	}
}
