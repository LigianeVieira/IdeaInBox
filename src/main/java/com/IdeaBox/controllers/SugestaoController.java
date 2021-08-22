package com.IdeaBox.controllers;



import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.IdeaBox.dto.ClassificacaoRequest;
import com.IdeaBox.models.sugestoes.Status_Sugestao;
import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.models.usuarios.Gerente;
import com.IdeaBox.repository.ColaboradorRepository;
import com.IdeaBox.repository.SugestaoRepository;



@Controller
public class SugestaoController {
	@Autowired
	private SugestaoRepository sr;
	
	@Autowired
	private ColaboradorRepository cr;

	@RequestMapping(value="/timeline", method=RequestMethod.POST)
	public String form(Sugestao sugestao, HttpSession session) {
		if(session.getAttribute("colaboradorLogado") != null) {
		Colaborador colaborador = (Colaborador)session.getAttribute("colaboradorLogado");
		sugestao.setColaborador(colaborador);
		colaborador.getSugestoes().add(sugestao);
		cr.save(colaborador);
		colaborador.getSugestoes().clear();
		}else { 
			Gerente gerente = (Gerente)session.getAttribute("gerenteLogado");
			sugestao.setColaborador(gerente);
			gerente.getSugestoes().add(sugestao);
			cr.save(gerente);
		}
		
		return "redirect:/timeline";
	}
	
	@RequestMapping("/deletarSugestao")
	public String deletarSugestao(long Id) {
	Sugestao sugestao = sr.findById(Id);
	sr.delete(sugestao);
		return "redirect:/profile";
	}
	
	@RequestMapping("/aprovarSugestao")
	public String aprovarSugestao(long Id) {
		Sugestao sugestao = sr.findById(Id);
		sugestao.setStatus(Status_Sugestao.APROVADO_PELO_RH);
		sr.save(sugestao);
		return "redirect:/profile";
	}
	
	@PostMapping("/avaliar")
	public String avaliarSugestao(@RequestParam(required = true) long id, ClassificacaoRequest classificacao) {
		Sugestao sugestao = sr.findById(id);
		sugestao.setClassificacao(classificacao.getClassificacao());
		
		sr.save(sugestao);
		return "redirect:/timeline";
	}
	
	

}
