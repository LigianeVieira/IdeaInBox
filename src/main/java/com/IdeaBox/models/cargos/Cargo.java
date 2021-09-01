package com.IdeaBox.models.cargos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.IdeaBox.models.usuarios.Colaborador;

@Entity
public class Cargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List <Colaborador> colaborador;
	
	
	
	public Cargo () {}
	
	
	public Cargo(String nome, Colaborador colaborador) {
		setNome(nome);
		setColaborador(getColaborador());
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private List<Colaborador> getColaborador() {
		return colaborador;
	}

	private void setColaborador(List<Colaborador> colaborador) {
		this.colaborador = colaborador;
	}


	@Override
	public String toString() {
		return super.toString();
	}

	
	
	
	
	
	

}
