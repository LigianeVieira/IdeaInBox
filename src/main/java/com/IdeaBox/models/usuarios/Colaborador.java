package com.IdeaBox.models.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Target;

import com.IdeaBox.models.cargos.Cargos;
import com.IdeaBox.models.sugestoes.Sugestao;
@Entity
public class Colaborador extends Usuario{
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity=Sugestao.class)
	protected List <Sugestao> sugestoes;
	
	@OneToMany
	private List<Cargos> cargos;
	
	public Colaborador(Integer id, String nome, String CPF, Cargos cargo, String login, String senha, String email) {
		super(id, nome, CPF,  cargo, login, senha, email);
		
		
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
	
	
	public List<Sugestao> getSugestoes() {
		return sugestoes;
	}



	public void setSugestoes(List<Sugestao> sugestoes) {
		this.sugestoes = sugestoes;
	}

}
