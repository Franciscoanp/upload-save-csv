package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "PESSOA")
public class Pessoa{

	@Id
	private String nome;
	private String idade;
	private String email;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String idade, String email) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", email=" + email + "]";
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	
	
}
