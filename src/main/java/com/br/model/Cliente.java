package com.br.model;

//Cliente.java


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Cliente {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long codigo;
 private String nome;
 
 
 

 public Cliente(Long codigo, String nome) {
	super();
	this.codigo = codigo;
	this.nome = nome;
}
 
 public Cliente() {
	 
 }
// Getters e Setters
 public Long getCodigo() { return codigo; }
 public void setCodigo(Long codigo) { this.codigo = codigo; }
 
 public String getNome() { return nome; }
 public void setNome(String nome) { this.nome = nome; }
 
}

