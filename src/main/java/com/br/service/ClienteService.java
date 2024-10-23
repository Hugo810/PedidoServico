package com.br.service;

import com.br.model.Cliente;
import com.br.model.ProdutoServico;
import com.br.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Buscar cliente por ID
    public Optional<Cliente> buscarPorId(Long codigo) {
        return clienteRepository.findById(codigo);
    }

    // Buscar cliente por código
    public Optional<Cliente> buscarPorCodigo(Long codigo) {
        return clienteRepository.findById(codigo); // Método que deve estar no repositório
    }

    // Salvar um novo cliente
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Atualizar cliente existente
    public Cliente atualizar(Long codigo, Cliente clienteAtualizado) {
        return clienteRepository.findById(codigo)
            .map(cliente -> {
                cliente.setNome(clienteAtualizado.getNome());
                return clienteRepository.save(cliente);
            })
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    // Deletar cliente por ID
    public void deletarPorId(Long codigo) {
        clienteRepository.deleteById(codigo);
    }
    
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome); // Supondo que você tenha esse método no repositório
    }
 
    
}
