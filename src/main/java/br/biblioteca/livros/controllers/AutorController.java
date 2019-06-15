package br.biblioteca.livros.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entidades.Autor;

@Controller
@RequestMapping("/autores")
public class AutorController {
	@GetMapping("/list")
	public ModelAndView list() {
		System.out.println("Listagem dos autores");
		return new ModelAndView("/autores/list");
	}
	
	@GetMapping("/novo")
	public ModelAndView newAutor() {
		System.out.println("Criei um novo autor");
		return new ModelAndView("/autores/autor");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		System.out.println("Alterei o autor com ID " + id);
		return new ModelAndView("redirect:/autores/list");
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		System.out.println("Exclui o autor com ID " + id);
		return new ModelAndView("redirect:/autores/list");
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(Autor autor) {
		System.out.println("Gravei o autor " + autor.toString());
	   return new ModelAndView("redirect:/autores/list");
	}
	

}
