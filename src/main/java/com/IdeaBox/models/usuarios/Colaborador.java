package com.IdeaBox.models.usuarios;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.IdeaBox.models.sugestoes.Sugestao;

@Entity
public class Colaborador extends Usuario{
	public Colaborador(Integer id, String nome, String CPF, Cargo cargo, String login, String senha, String email) {
		super(id, nome, CPF, cargo, login, senha, email);
		setId(id);
		setNome(nome);
		setCpf(CPF);
		setCargo(cargo);
		setLogin(login);
		setSenha(senha);
		setEmail(email);
		setStatus(StatusColaborador.ATIVO);
		sugestoes = new ArrayList<Sugestao>();
	}
	public Colaborador() {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	

}
