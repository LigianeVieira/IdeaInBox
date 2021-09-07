package com.IdeaBox.models.usuarios;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.IdeaBox.exceptions.CpfException;
import com.IdeaBox.exceptions.SenhaLowException;
import com.IdeaBox.models.cargos.Cargo;
import com.IdeaBox.models.sugestoes.Sugestao;



@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	

	@Column(length = 45, nullable = false, unique = false)
	private String nome;
	
	@Column(length = 11, nullable = false, unique = true)
	private String cpf = "17313020023";
	 
	@ManyToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
    

	@Column(length = 25, nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false, unique = false)
	private String senha = "------";
	
	@Email
	@Column(nullable = false, unique = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private StatusColaborador status;
	
	


	public Usuario(long id, String nome, String cpf, Cargo cargo, String login, String senha, String email) throws CpfException, SenhaLowException {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setCargo(cargo);
		setLogin(login);
		setSenha(senha);
		setEmail(email);
		setStatus(StatusColaborador.ATIVO); 
		
	}
	public Usuario() throws CpfException, SenhaLowException {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setCargo(cargo);
		setLogin(login);
		setSenha(senha);
		setEmail(email);
		setStatus(StatusColaborador.ATIVO);
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public void setCpf(String cpf) throws CpfException {
		if(cpf.isEmpty()) {
			throw new CpfException("Cpf incorreto");
		}
		if(cpf.length() > 11 || cpf.length() < 11) {
			throw new CpfException("quantidade de numeros do cpf incorretos.");
		}
		
		 if (cpf.length() != 11)
	            throw new CpfException("CPF precisa conter 11 números, sem caracteres especiais.");
	        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
	                || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
	                || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
	                || cpf.equals("99999999999"))
	            
	            throw new CpfException("CPF inválido, não pode conter todos números identicos");
	   
	        int d10 = -1;
	        int d11 = -1;
	        int somaD10 = (cpf.charAt(0) - 48) * 10 + (cpf.charAt(1) - 48) * 9 + (cpf.charAt(2) - 48) * 8
	                + (cpf.charAt(3) - 48) * 7 + (cpf.charAt(4) - 48) * 6 + (cpf.charAt(5) - 48) * 5
	                + (cpf.charAt(6) - 48) * 4 + (cpf.charAt(7) - 48) * 3 + (cpf.charAt(8) - 48) * 2;
	        int restoD10 = somaD10 % 11;
	        if (restoD10 < 2) {

	            d10 = 0;
	        } else {

	            d10 = 11 - restoD10;

	        }

	        int somaD11 = (cpf.charAt(1) - 48) * 10 + (cpf.charAt(2) - 48) * 9 + (cpf.charAt(3) - 48) * 8
	                + (cpf.charAt(4) - 48) * 7 + (cpf.charAt(5) - 48) * 6 + (cpf.charAt(6) - 48) * 5
	                + (cpf.charAt(7) - 48) * 4 + (cpf.charAt(8) - 48) * 3 + (cpf.charAt(9) - 48) * 2;

	        int restoD11 = somaD11 % 11;

	        if (restoD11 < 2) {
	            d11 = 0;
	        } else {
	            d11 = 11 - restoD11;
	        }

	        if (d10 != (cpf.charAt(9) - 48) || d11 != (cpf.charAt(10) - 48)) {
	            throw new CpfException(" O Cpf é inválido");
	        }
		
		this.cpf = cpf;
	}
		
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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
	public void setSenha(String senha) throws SenhaLowException {
		if(senha.isEmpty()) {
			throw new SenhaLowException("Senha vazia");
		}
		if(senha.length() < 6) {
			throw new SenhaLowException("Senha muito fraca, tente novamente");
		}
		this.senha = senha;
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
