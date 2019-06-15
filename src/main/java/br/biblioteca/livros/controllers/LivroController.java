package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Livro;
@Controller
@RequestMapping("/livros")
public class LivroController {
	
	@GetMapping("/list")
	public ModelAndView list() {
		System.out.println("Listagem dos livros");
		return new ModelAndView("/livros/list");
	}
	
	@GetMapping("/novo")
	public ModelAndView newBook() {
		System.out.println("Criei um novo livro");
		return new ModelAndView("/livros/livro");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		System.out.println("Alterei o livro com ID " + id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		System.out.println("Exclui o livro com ID " + id);
		return new ModelAndView("redirect:/livros/list");
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(Livro livro) {
		System.out.println("Gravei o livro " + livro.toString());
	   return new ModelAndView("redirect:/livros/list");
	}
	
		
}
