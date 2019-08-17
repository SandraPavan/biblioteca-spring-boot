package br.biblioteca.livros.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.OneToMany;

public class Role {
	String role;

	@OneToMany(mappedBy = "user")
	private List<User> user = new ArrayList<>();

	public Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Role [role=" + role + "]";
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}
