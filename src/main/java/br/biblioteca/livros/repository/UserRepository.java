package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.biblioteca.livros.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String username);
}
