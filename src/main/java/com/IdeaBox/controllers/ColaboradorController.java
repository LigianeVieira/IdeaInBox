package com.IdeaBox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.repository.ColaboradorRepository;

@Controller
public class ColaboradorController {
	@Autowired
	private ColaboradorRepository cr;
	
	@RequestMapping(value="/cadastrarColaborador", method=RequestMethod.GET)
	public String form() {
		return "colaborador/formColaborador.html";
	}
	
	@RequestMapping(value="/cadastrarColaborador", method=RequestMethod.POST)
	public String form(Colaborador colaborador) {
		cr.save(colaborador);
		return "redirect:/cadastrarColaborador";
	}

}
