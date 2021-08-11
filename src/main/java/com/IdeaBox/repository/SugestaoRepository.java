package com.IdeaBox.repository;

import javax.servlet.http.HttpSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Colaborador;

public interface SugestaoRepository extends CrudRepository<Sugestao, String>{
	
	Iterable<Sugestao> findByColaborador(Colaborador colaborador);
	
	Sugestao findById(long id);

}
