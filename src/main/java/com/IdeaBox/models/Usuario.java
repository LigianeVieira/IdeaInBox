package com.IdeaBox.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	private String nome;
	private String cpf;
	private String cargo;
	protected boolean isRegistrado;
	private String login;
	private String senha;
	private boolean isLogado;
	private String email;
	@Enumerated(EnumType.STRING)
	private StatusColaborador status;
	
	public Usuario(Integer id, String nome, String cpf, String cargo, String login, String senha, String email) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setCargo(cargo);
		setLogin(login);
		setSenha(senha);
		setEmail(email);
		setLogado(false);
		setRegistrado(true);
		setStatus(StatusColaborador.ATIVO);
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public boolean isRegistrado() {
		return isRegistrado;
	}
	public void setRegistrado(boolean isRegistrado) {
		this.isRegistrado = isRegistrado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isLogado() {
		return isLogado;
	}
	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public StatusColaborador getStatus() {
		return status;
	}
	public void setStatus(StatusColaborador status) {
		this.status = status;
	}
	
}
