package com.IdeaBox.models.sugestoes;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.IdeaBox.models.usuarios.Colaborador;






@Entity
public class Sugestao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String sugestao;
	private String criacaoDaSugestao;
	@ManyToOne
	private Colaborador colaborador;
	private double classificacao;
	@Enumerated(EnumType.STRING)
	private Status_Sugestao status;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private int totalDeAvaliacoes;

	
	public Sugestao() {
		
	}
	
	public Sugestao(Integer id, Colaborador colaborador, Categoria categoria, String Sugestao){
		super();
		setColaborador(colaborador);
		setStatus(status.RECEBIDO);
		setClassificacao(0);
		this.criacaoDaSugestao = this.getData();
		setSugestao(Sugestao);
		this.setTotalDeAvaliacoes(0);
		this.setId(Id);
		setCategoria(categoria);
	}
	
	private String getData() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public int getTotalDeAvaliacoes() {
		return totalDeAvaliacoes;
	}



	public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
		this.totalDeAvaliacoes = totalDeAvaliacoes;
	}



	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao){
		this.sugestao = sugestao;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	


	public double getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(double classificacao) {
		this.classificacao = classificacao;
	}

	public Status_Sugestao getStatus() {
		return status;
	}

	public void setStatus(Status_Sugestao status) {
		this.status = status;
	}


	public Integer getId() {
		return Id;
	}





	public void setId(Integer id) {
		Id = id;
	}
}


