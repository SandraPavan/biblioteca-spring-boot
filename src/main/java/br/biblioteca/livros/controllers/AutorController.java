package br.biblioteca.livros.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.services.AutorService;

@Controller
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	private AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list() {

		List<Autor> autores = autorService.listarAutor();
		return new ModelAndView("/autores/list", "listaAutores", autores);
	}

	@GetMapping("/novo")
	public ModelAndView newAutor(@ModelAttribute Autor autor) {
		return new ModelAndView("autores/autor");
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(@ModelAttribute("autor") @Valid Autor autor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("autores/autor");
		}
		autorService.gravarAutor(autor);
		return new ModelAndView("redirect:/autores/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		Autor autor = autorService.buscaAutor(id);
		ModelAndView modelAndView = new ModelAndView("autores/autor");
		autorService.alterarAutor(autor);
		modelAndView.addObject("autor", autor);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		autorService.apagarLivro(id);
		return new ModelAndView("redirect:/autores/list");
	}

}
