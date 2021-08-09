package com.IdeaBox.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.IdeaBox.exceptions.ServiceExce;
import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.repository.ColaboradorRepository;
import com.IdeaBox.repository.SugestaoRepository;
import com.IdeaBox.service.ServiceUsuario;
import com.IdeaBox.util.Util;


@Controller
public class UsuarioController {
	
	@Autowired
	private ColaboradorRepository cr;
	
	@Autowired
	private SugestaoRepository sr;
	
	@Autowired
	private ServiceUsuario su;
	
	@GetMapping("/timeline")
	public ModelAndView listaSugestao(HttpSession session) {
		if(session.getAttribute("colaboradorLogado") != null) {
		ModelAndView mv = new ModelAndView("feed");
		Iterable<Sugestao> sugestoes = sr.findAll();
		mv.addObject("sugestoes", sugestoes);
		return mv;}
		else {
			return error();
		}
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		ModelAndView mv = new ModelAndView("error");
		return mv;
	}

	
	
	
	@PostMapping("/login")
	public ModelAndView login(Colaborador colaborador, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExce {
		ModelAndView mv = new ModelAndView();
		mv.addObject("colaborador", new Colaborador());
		if(br.hasErrors()) {
			mv.setViewName("login");
		}
		Colaborador colaboradorLogin = su.loginColaborador(colaborador.getLogin(), Util.md5(colaborador.getSenha()));
		if(colaboradorLogin == null) {
			mv.addObject("msg", "Usuario não encontrado tente novamente");
		}
		else {
			session.setAttribute("colaboradorLogado", colaboradorLogin);
			return index();
		}
		return mv;
		
	}
	
	@GetMapping("/login")
	public ModelAndView loginGet() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		mv.addObject("colaborador", new Colaborador());
		return mv;
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
	
}
