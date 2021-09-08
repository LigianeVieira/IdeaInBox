package com.IdeaBox.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.IdeaBox.models.sugestoes.Sugestao;
import com.IdeaBox.models.usuarios.Colaborador;
import com.IdeaBox.repository.ColaboradorRepository;
import com.IdeaBox.repository.SugestaoRepository;
import com.IdeaBox.service.ServiceUsuario;


@Controller
public class ColaboradorController {
	@Autowired
	private ColaboradorRepository cr;
	
	@Autowired
	private SugestaoRepository sr;
	
	@Autowired
	private ServiceUsuario su;
	
	
	

	
	@GetMapping("/colaboradores")
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
	
	@PostMapping("/editarNome")
	 public String editarColaborador(@RequestParam long id, @RequestParam("nome") String nome) {
			Colaborador colaborador = cr.findById(id);
			colaborador.setNome(nome);
			cr.save(colaborador);
				return "redirect:/colaboradores";
			}

}
