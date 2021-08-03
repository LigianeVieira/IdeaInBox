package com.IdeaBox.models.usuarios;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

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
		setLogado(false);
		setRegistrado(true);
		setStatus(StatusColaborador.ATIVO);
	}
	public Colaborador() {
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	

}
