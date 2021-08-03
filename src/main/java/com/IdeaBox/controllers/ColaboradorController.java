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
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/timeline{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") long id) {
		Colaborador colaborador = cr.findById(id);
		ModelAndView mv = new ModelAndView("feed");
		mv.addObject("colaborador", colaborador);
		Iterable<Sugestao> sugestoes = sr.findAll();
		mv.addObject("sugestoes", sugestoes);
		return mv;
	}
	
	
	@RequestMapping(value = "/timeline{id}", method = RequestMethod.POST)
	public String feedPost(@PathVariable("id") long id, Sugestao sugestao){
		Colaborador colaborador = cr.findById(id);
		sugestao.setColaborador(colaborador);
		sr.save(sugestao);
		return "redirect:/timeline{id}";
	}

}
