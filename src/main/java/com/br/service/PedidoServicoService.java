package com.br.service;

//PedidoServicoService.java

import com.br.model.PedidoServico;
import com.br.repository.PedidoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicoService {

 private final PedidoServicoRepository pedidoServicoRepository;

 public PedidoServicoService(PedidoServicoRepository pedidoServicoRepository) {
     this.pedidoServicoRepository = pedidoServicoRepository;
 }

 public List<PedidoServico> listarTodos() {
     return pedidoServicoRepository.findAll();
 }

 public Optional<PedidoServico> buscarPorId(Long id) {
     return pedidoServicoRepository.findById(id);
 }

 public PedidoServico salvar(PedidoServico pedidoServico) {
     return pedidoServicoRepository.save(pedidoServico);
 }

 public void deletarPorId(Long id) {
     pedidoServicoRepository.deleteById(id);
 }
 
 
 

}
