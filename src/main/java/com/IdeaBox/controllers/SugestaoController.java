package com.IdeaBox.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.repository.SugestaoRepository;


@Controller
public class SugestaoController {
	@Autowired
	private SugestaoRepository sr;
	
	@RequestMapping(value="/feed", method=RequestMethod.GET)
	public String form() {
		return "feed";
	}
	

	@RequestMapping(value="/timeline", method=RequestMethod.POST)
	public String form(Sugestao sugestao) {
		sr.save(sugestao);
		return "redirect:/timeline";
	}
	
	@RequestMapping("/timeline")
	public ModelAndView listaSugestao() {
		ModelAndView mv = new ModelAndView("feed");
		Iterable<Sugestao> sugestoes = sr.findAll();
		mv.addObject("sugestoes", sugestoes);
		return mv;
	}

}
