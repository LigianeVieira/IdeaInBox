package com.IdeaBox.models.usuarios;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Entity
public class Administrador extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador() {
		
	}
}
