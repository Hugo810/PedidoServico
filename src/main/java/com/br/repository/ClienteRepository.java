package com.br.repository;

import java.util.List;

//ClienteRepository.java


import org.springframework.data.jpa.repository.JpaRepository;

import com.br.model.Cliente;



	
	public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	   List<Cliente> findByNomeContainingIgnoreCase(String nome);
	}

