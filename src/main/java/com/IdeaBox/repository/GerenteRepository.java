package com.IdeaBox.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.usuarios.Gerente;

public interface GerenteRepository extends CrudRepository<Gerente, String>{
	
	@Query("select u from Gerente u where u.login = :login and u.senha = :senha")
	Gerente findByLogin(String login, String senha);
	
}
