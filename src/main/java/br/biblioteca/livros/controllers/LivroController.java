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
import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {
	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorService autorService;

	@GetMapping("/list")
	public ModelAndView list() {
		List<Livro> livros = livroService.listarLivro();
		return new ModelAndView("/livros/list", "listaLivros", livros);
	}

	@GetMapping("/novo")
	public ModelAndView newBook(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/livro");
		Iterable<Autor> autores = autorService.listarAutor();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	@PostMapping(value = "/gravar")
	public ModelAndView create(@ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("livros/livro");
		}
		livroService.gravarLivro(livro);
		return new ModelAndView("redirect:/livros/list");
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView update(@PathVariable("id") Long id) {
		Livro livro = livroService.buscaLivro(id);
		List<Autor> autores = autorService.listarAutor();
		ModelAndView modelAndView = new ModelAndView("livros/livro");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

	@GetMapping("/excluir/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		livroService.apagarLivro(id);
		return new ModelAndView("redirect:/livros/list");
	}

}
