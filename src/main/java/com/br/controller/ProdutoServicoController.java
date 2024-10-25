package com.br.controller;

import com.br.model.ProdutoServico;
import com.br.service.ProdutoServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoServicoController {

    private final ProdutoServicoService produtoServicoService;

    public ProdutoServicoController(ProdutoServicoService produtoServicoService) {
        this.produtoServicoService = produtoServicoService;
    }

    @GetMapping
    public List<ProdutoServico> listarProdutos() {
        return produtoServicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoServico> buscarPorId(@PathVariable Long id) {
        return produtoServicoService.buscarPorId(id);
    }

    @GetMapping("/buscarPorNome") // Ajustado para usar RequestParam
    public List<ProdutoServico> buscarProdutosPorNome(@RequestParam String nome) {
        return produtoServicoService.buscarPorNome(nome);
    }

    @PostMapping
    public ProdutoServico salvarProduto(@RequestBody ProdutoServico produtoServico) {
        return produtoServicoService.salvar(produtoServico);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id) {
        produtoServicoService.deletarPorId(id);
    }
}
