package com.IdeaBox.models.sugestoes;



import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.IdeaBox.models.usuarios.Colaborador;






@Entity
public class Sugestao implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String texto;
	@ManyToOne
	private Colaborador colaborador;
	private double classificacao;
	@Enumerated(EnumType.STRING)
	private Status_Sugestao status = Status_Sugestao.EM_ANALISE_RH;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	private int totalDeAvaliacoes;
	private ZonedDateTime dataEnvio = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));


	
	
	public Sugestao() {
		
	}
	
	public Sugestao(Integer id, Colaborador colaborador, Categoria categoria, String texto){
		super();
		setColaborador(colaborador);
		setClassificacao(0);
		setTexto(texto);
		this.setTotalDeAvaliacoes(0);
		this.setId(id);
		setCategoria(categoria);
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



	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto){
		this.texto = texto;
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


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	
	public ZonedDateTime getDataEnvio() {
		return dataEnvio;
	}

	

	

	
	
}


