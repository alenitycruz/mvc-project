package com.gft.culinaria.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.culinaria.entities.Ingrediente;
import com.gft.culinaria.services.IngredienteService;

@Controller
@RequestMapping("ingrediente")
public class IngredienteController {
	
	@Autowired
	IngredienteService ingredienteService;

	@RequestMapping(path="novo")
	public ModelAndView novoIngrediente() {
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		
		mv.addObject("ingrediente", new Ingrediente());
		
		return mv;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, path="novo")
	public ModelAndView salvarIngrediente(@Valid Ingrediente ingrediente, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		
		if(bindingResult.hasErrors()) {
			mv.addObject("ingrediente", ingrediente);
			return mv;
		}
		
		
		mv.addObject("ingrediente", new Ingrediente());
		ingredienteService.salvarIngrediente(ingrediente);
		
		mv.addObject("mensagem", "Ingrediente salvo com sucesso!");
		
		return mv;
	}
	
	
	
	
	@RequestMapping
	public ModelAndView listarIngrediente() {
		
		ModelAndView mv = new ModelAndView("ingrediente/listar.html");
		mv.addObject("lista", ingredienteService.listarIngrediente());
		
		
		return mv;
		
	}
	
	
	@RequestMapping(path="/editar")
	public ModelAndView editarIngrediente(@RequestParam Long id) {
		
		ModelAndView mv = new ModelAndView("ingrediente/form.html");
		
		Ingrediente ingrediente;
		
		try {
			
			ingrediente = ingredienteService.obterIngrediente(id);
			
		} catch(Exception e) {
			
			ingrediente = new Ingrediente();
			mv.addObject("mensagem", e.getMessage());
			
		}
		
		mv.addObject("ingrediente", ingrediente);
		
		return mv;
	}
	
	@RequestMapping(path="/excluir")
	public ModelAndView excluirIngrediente(@RequestParam Long id, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/ingrediente");

		
		try {
			
			ingredienteService.excluirIngrediente(id);
			redirectAttributes.addFlashAttribute("mensagem", "Ingrediente excluido com sucesso");	
		} catch(Exception e) {
			
			redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir Ingrediente" + e.getMessage());	
			
		}
				
		return mv;
	}
	
	
}
