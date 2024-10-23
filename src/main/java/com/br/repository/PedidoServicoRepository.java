package com.br.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.br.model.Cliente;
import com.br.model.PedidoServico;
import com.br.model.ProdutoServico;

public interface PedidoServicoRepository extends JpaRepository<PedidoServico, Long> {
	
}

