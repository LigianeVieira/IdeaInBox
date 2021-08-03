package com.IdeaBox.repository;

import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.usuarios.Colaborador;

public interface ColaboradorRepository extends CrudRepository<Colaborador, String>{
	Colaborador findById(long id);
}
