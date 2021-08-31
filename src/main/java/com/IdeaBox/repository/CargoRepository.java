package com.IdeaBox.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.cargos.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, String>{
	
	@Query(value = "select nome from Cargo where nome=?", nativeQuery = true)
	Cargo findNome(String nome);
	
}
