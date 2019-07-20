package br.biblioteca.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entities.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	LivroRepository repository;

	public List<Livro> listarLivro() {
		return repository.findAll();
	}

	public void gravarLivro(Livro livro) {
		repository.save(livro);
	}

	public void alterarLivro(Livro livro) {
		repository.save(livro);
	}

	public Livro buscaLivro(Long id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElse(null);
	}

	public void apagarLivro(Long id) {
		Optional<Livro> livro = repository.findById(id);
		if (livro.isPresent()) {
			repository.delete(livro.get());
		}
	}

}
