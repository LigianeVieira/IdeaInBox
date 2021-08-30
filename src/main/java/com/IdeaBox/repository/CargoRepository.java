package com.IdeaBox.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.cargos.Cargos;

public interface CargoRepository extends CrudRepository<Cargos, String>{
	
	@Query(value = "select nome from Cargos where nome=?", nativeQuery = true)
	Cargos findNome(String nome);
	
}
