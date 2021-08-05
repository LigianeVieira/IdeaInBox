package com.IdeaBox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.usuarios.Colaborador;

public interface ColaboradorRepository extends CrudRepository<Colaborador, String>{
	Colaborador findById(long id);
	@Query("select i from Colaborador i where i.email = :email")
	Colaborador findByEmail(String email);
	
	@Query("select u from Colaborador u where u.login = :login and u.senha = :senha")
	Colaborador findLogin(String login, String senha);
}


