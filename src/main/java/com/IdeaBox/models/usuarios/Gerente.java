package com.IdeaBox.models.usuarios;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.IdeaBox.exceptions.CpfException;

@Entity
public class Gerente extends Colaborador{

	private static final long serialVersionUID = 1L;
	
	

	
	public Gerente() throws CpfException{
		
	}
	
	
}
