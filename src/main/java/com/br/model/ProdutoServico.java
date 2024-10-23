package com.br.model;

import java.util.List;

//ProdutoServico.java


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ProdutoServico {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long codigo;
 private String nome;
 private double qtde;
 private double valor;
public ProdutoServico(Long codigo, String nome, double qtde, double valor) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.qtde = qtde;
	this.valor = valor;
}
public ProdutoServico() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public double getQtde() {
	return qtde;
}
public void setQtde(double qtde) {
	this.qtde = qtde;
}
public double getValor() {
	return valor;
}
public void setValor(double valor) {
	this.valor = valor;
}

 
 
}
