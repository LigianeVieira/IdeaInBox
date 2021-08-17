package com.IdeaBox.repository;



import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.kotlin.CoroutineCrudRepository;

import com.IdeaBox.models.usuarios.Administrador;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.models.usuarios.Gerente;

public interface ColaboradorRepository extends CrudRepository<Colaborador, String>{
	Colaborador findById(long id);
	@Query("select i from Colaborador i where i.email = :email")
	Colaborador findByEmail(String email);
	
	@Query("select i from Gerente i where i.email = :email")
	Gerente findByEmailG(String email);

	
	@Query("select u from Colaborador u where u.login = :login and u.senha = :senha")
	Colaborador findLogin(String login, String senha);
	
	@Query("select u from Administrador u where u.login = :login and u.senha = :senha")
	Administrador findByLoginA(String login, String senha);

	
}


