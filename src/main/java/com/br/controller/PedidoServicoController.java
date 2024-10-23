package com.br.controller;

import com.br.model.Cliente; // Certifique-se de ter o modelo Cliente
import com.br.service.ClienteService; // Importe o serviço de cliente
import com.br.model.PedidoServico;
import com.br.model.ProdutoServico;
import com.br.service.PedidoServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.br.model.ProdutoServico;
@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoServicoController {

    private final PedidoServicoService pedidoServicoService;
    private final ClienteService clienteService; // Adicione o serviço de cliente

    public PedidoServicoController(PedidoServicoService pedidoServicoService, ClienteService clienteService) {
        this.pedidoServicoService = pedidoServicoService;
        this.clienteService = clienteService; // Inicialize o serviço de cliente
    }

    @GetMapping
    public List<PedidoServico> listarPedidos() {
        return pedidoServicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PedidoServico> buscarPorId(@PathVariable Long codigo) {
        return pedidoServicoService.buscarPorId(codigo);
    }

    @PostMapping
    public PedidoServico salvarPedido(@RequestBody PedidoServico pedidoServico) {
        return pedidoServicoService.salvar(pedidoServico);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id) {
        pedidoServicoService.deletarPorId(id);
    }

    // Método para buscar cliente pelo código
    @GetMapping("/clientes/{codigo}")
    public Optional<Cliente> buscarCliente(@PathVariable Long codigo) {
        return clienteService.buscarPorCodigo(codigo); // Implementar no serviço
    }
    
    @GetMapping("/clientes/nome/{nome}")
    public List<Cliente> buscarClientesPorNome(@PathVariable String nome) {
        return clienteService.buscarPorNome(nome);
    }
    
    /*@GetMapping("/produtos/buscarPorNome{nome}")
    public List<ProdutoServico> buscarPorNome(@RequestParam String nome) {
        return produtoServicoService.buscarPorNome(nome);
    }*/

}
