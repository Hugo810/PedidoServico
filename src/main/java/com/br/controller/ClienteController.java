package com.br.controller;

//ClienteController.java

//ClienteController.java

import com.br.model.Cliente;
import com.br.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

 private final ClienteService clienteService;

 public ClienteController(ClienteService clienteService) {
     this.clienteService = clienteService;
 }

 @GetMapping
 public List<Cliente> listarClientes() {
     return clienteService.listarTodos();
 }

 @GetMapping("/{id}")
 public Optional<Cliente> buscarPorId(@PathVariable Long id) {
     return clienteService.buscarPorId(id);
 }

 @PostMapping
 public Cliente salvarCliente(@RequestBody Cliente cliente) {
     return clienteService.salvar(cliente);
 }

 @PutMapping("/{id}")
 public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
     return clienteService.atualizar(id, clienteAtualizado);
 }

 @DeleteMapping("/{id}")
 public void deletarCliente(@PathVariable Long id) {
     clienteService.deletarPorId(id);
 }
 @GetMapping("buscarPorNome/{nome}")
 public List<Cliente> buscarClientesPorNome(@PathVariable("nome") String nome) {
     return clienteService.buscarPorNome(nome);
 }

}
