package br.up.edu.arquitetura.biblioteca.model.persistencia;

import java.util.ArrayList;


		import br.up.edu.arquitetura.biblioteca.model.dominio.Mutuario;

public class MutuarioPersistencia {
	
	private static ArrayList<Mutuario> mutuarios = new ArrayList<Mutuario>();
	private static int id = 0;

	public Mutuario insert(Mutuario mutuario) {
		//salvar no array
		if(mutuarios.size() == 0){
			mutuario.setId(id + 1);
			System.out.println(mutuario.getId());
		} else {
			mutuario.setId(id);
			id++;
		}
		
		mutuarios.add(mutuario);
		
		return mutuarios.get(mutuario.getId());
	}

	public ArrayList<Mutuario> list() {
		//lista de mutuarios 
		return mutuarios;
	}

	public Mutuario findId(int id) {
		// busca pelo id
		return mutuarios.get(id);	
	}

	public Mutuario update(Mutuario mutuario) {
		Mutuario aux = mutuarios.get(mutuario.getId());
		
		aux.setId(mutuario.getId());
		aux.setNome(mutuario.getNome());
		aux.setEndereco(mutuario.getEndereco());
		aux.setTelefone(mutuario.getTelefone());
		
		return aux;
	}
	
	public Mutuario find (String nome) {
		Mutuario mutuarioRetorno = null;
		for (Mutuario mutuario : mutuarios) {
			if (mutuario.getNome().equals(nome)) {
				mutuarioRetorno = mutuario;
			}
		}
		return mutuarioRetorno;
	}
	
}
