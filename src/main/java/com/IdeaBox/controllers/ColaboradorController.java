package com.IdeaBox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.repository.ColaboradorRepository;
import com.IdeaBox.repository.SugestaoRepository;


@Controller
public class ColaboradorController {
	@Autowired
	private ColaboradorRepository cr;
	
	@Autowired
	private SugestaoRepository sr;
	
	@RequestMapping(value="/cadastrarColaborador", method=RequestMethod.GET)
	public String form() {
		return "colaborador/formColaborador.html";
	}
	
	@RequestMapping(value="/cadastrarColaborador", method=RequestMethod.POST)
	public String form(Colaborador colaborador) {
		cr.save(colaborador);
		return "redirect:/cadastrarColaborador";
	}

	

	
	@RequestMapping("/colaboradores")
	public ModelAndView listaSugestao() {
		ModelAndView mv = new ModelAndView("colaborador/listaColaboradores");
		Iterable<Colaborador> colaboradores = cr.findAll();
		mv.addObject("colaboradores", colaboradores);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarColaborador(long Id) {
		Colaborador colaborador = cr.findById(Id);
		cr.delete(colaborador);
		return "redirect:/colaboradores";
	}

}
