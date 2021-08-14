package com.IdeaBox.controllers;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.IdeaBox.exceptions.ServiceExce;
import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Administrador;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.models.usuarios.Gerente;
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
		if (session.getAttribute("colaboradorLogado") != null) {
			ModelAndView mv = new ModelAndView("feed");
			Iterable<Sugestao> sugestoes = sr.findAllByStatus();
			mv.addObject("sugestoes", sugestoes);
			return mv;
		} else {
			return loginGet();
		}
	}

	@GetMapping("/erroLogin")
	public ModelAndView error() {
		ModelAndView mv = new ModelAndView("naoLogado");
		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(Colaborador colaborador, Gerente gerente, Administrador adm, BindingResult br,
			HttpSession session) throws NoSuchAlgorithmException, ServiceExce {
		ModelAndView mv = new ModelAndView();
		mv.addObject("colaborador", new Colaborador());
		if (br.hasErrors()) {
			mv.setViewName("login");
		}
		Colaborador colaboradorLogin = su.loginColaborador(colaborador.getLogin(), Util.md5(colaborador.getSenha()));
		Administrador administradorLogin = su.loginAdm(adm.getLogin(), adm.getSenha());
		Gerente gerenteLogin = su.loginGerente(gerente.getLogin(), gerente.getSenha());
		if (colaboradorLogin == null && administradorLogin == null && gerenteLogin == null) {
			mv.addObject("msg", "Usuario não encontrado tente novamente");
		} else if (colaboradorLogin != null) {
			session.setAttribute("colaboradorLogado", colaboradorLogin);
			return index(session);
		} else if (administradorLogin != null) {
			session.setAttribute("AdmLogado", administradorLogin);
			return index(session);
		} else {
			session.setAttribute("gerenteLogado", gerenteLogin);
			return index(session);
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
	public ModelAndView index(HttpSession session) {
		ModelAndView mv = new ModelAndView("index");
		if (session.getAttribute("colaboradorLogado") != null || session.getAttribute("AdmLogado") != null || session.getAttribute("gerenteLogado") != null) {
			return mv;
		}
		// AdmLogado
		else {
			mv.addObject("logadoexce", "Logue para acessar as funcionalidades do sistema.");
			return mv;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/profile")
	public ModelAndView perfilGet(HttpSession session) {
		if (session.getAttribute("colaboradorLogado") != null) {
			Colaborador colaborador = (Colaborador) session.getAttribute("colaboradorLogado");
			ModelAndView mv = new ModelAndView("colaborador/profile");
			mv.addObject("colaborador", colaborador);
			Iterable<Sugestao> sugestoes = sr.findByColaborador(colaborador);
			mv.addObject("sugestoes", sugestoes);
			return mv;
		} 
		
		else if (session.getAttribute("AdmLogado") != null) {
			Administrador administrador = (Administrador) session.getAttribute("AdmLogado");
			ModelAndView mv = new ModelAndView("colaborador/profileadm");
			mv.addObject("administrador", administrador);
			Iterable<Sugestao> sugestoes = sr.findAllInAnalise();
			mv.addObject("sugestoes", sugestoes);
			return mv;
		} 
		else if(session.getAttribute("gerenteLogado") != null) {
			Gerente gerente = (Gerente) session.getAttribute("gerenteLogado");
			ModelAndView mv = new ModelAndView("colaborador/profilegerente");
			mv.addObject("gerente",gerente);
			Iterable<Sugestao> sugestoes = sr.findAllInAnalise();
			mv.addObject("sugestoes", sugestoes);
			return mv;
		}
		else {
			return loginGet();
		}
	}

	@GetMapping("/cadastrarColaborador")
	public ModelAndView form(HttpSession session) {
		ModelAndView mv = new ModelAndView("colaborador/formColaborador");
		if (session.getAttribute("AdmLogado") != null || session.getAttribute("gerenteLogado") != null) {
			return mv;
		} else {
			return loginGet();
		}
	}

	@RequestMapping(value = "/cadastrarColaborador", method = RequestMethod.POST)
	public String form(Colaborador colaborador) throws Exception {
		su.salvarColaborador(colaborador);
		return "redirect:/cadastrarColaborador";
	}

}
