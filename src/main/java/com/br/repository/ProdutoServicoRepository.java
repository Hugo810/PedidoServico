package com.br.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.ProdutoServico;

public interface ProdutoServicoRepository extends JpaRepository<ProdutoServico, Long> {
    List<ProdutoServico> findByNomeContaining(String nome); // Corrigido para 'nome'
}
