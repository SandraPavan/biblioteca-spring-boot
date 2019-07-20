package br.biblioteca.livros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.entities.Autor;
import br.biblioteca.livros.repository.AutorRepository;

@Service
public class AutorService {
	@Autowired
	AutorRepository repository;

	public List<Autor> listarAutor() {
		return repository.findAll();
	}

	public void gravarAutor(Autor autor) {
		repository.save(autor);
	}

	public void alterarAutor(Autor autor) {
		repository.save(autor);
	}

	public Autor buscaAutor(Long id) {
		return repository.findById(id).get();
	}

	public void apagarLivro(Long id) {
		Optional<Autor> autor = repository.findById(id);
		if (autor.isPresent()) {
			repository.delete(autor.get());
		}
	}

}
