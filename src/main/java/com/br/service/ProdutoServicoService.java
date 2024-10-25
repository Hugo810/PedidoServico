package com.br.service;

import com.br.model.ProdutoServico;
import com.br.repository.ProdutoServicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServicoService {

    private final ProdutoServicoRepository produtoServicoRepository;

    public ProdutoServicoService(ProdutoServicoRepository produtoServicoRepository) {
        this.produtoServicoRepository = produtoServicoRepository;
    }

    public List<ProdutoServico> listarTodos() {
        return produtoServicoRepository.findAll();
    }

    public Optional<ProdutoServico> buscarPorId(Long id) {
        return produtoServicoRepository.findById(id);
    }

    public List<ProdutoServico> buscarPorNome(String nome) {
        return produtoServicoRepository.findByNomeContaining(nome); // Corrigido para 'nome'
    }

    public ProdutoServico salvar(ProdutoServico produtoServico) {
        return produtoServicoRepository.save(produtoServico);
    }

    public void deletarPorId(Long id) {
        produtoServicoRepository.deleteById(id);
    }
}
