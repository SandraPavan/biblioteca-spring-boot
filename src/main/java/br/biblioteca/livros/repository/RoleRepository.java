package br.biblioteca.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.biblioteca.livros.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String role);

}