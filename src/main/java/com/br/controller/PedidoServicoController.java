package com.br.controller;

import com.br.model.Cliente; // Certifique-se de ter o modelo Cliente
import com.br.model.PedidoServico;
import com.br.model.ProdutoServico; // Importar o modelo ProdutoServico
import com.br.service.ClienteService; // Importe o serviço de cliente
import com.br.service.PedidoServicoService;
import com.br.service.ProdutoServicoService; // Importe o serviço de produtos
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class PedidoServicoController {

    private final PedidoServicoService pedidoServicoService;
    private final ClienteService clienteService; // Serviço de cliente
    private final ProdutoServicoService produtoServicoService; // Serviço de produtos

    public PedidoServicoController(PedidoServicoService pedidoServicoService, ClienteService clienteService, ProdutoServicoService produtoServicoService) {
        this.pedidoServicoService = pedidoServicoService;
        this.clienteService = clienteService; // Inicializa o serviço de cliente
        this.produtoServicoService = produtoServicoService; // Inicializa o serviço de produtos
    }

    @GetMapping
    public List<PedidoServico> listarPedidos() {
        return pedidoServicoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<PedidoServico> buscarPorId(@PathVariable Long id) {
        return pedidoServicoService.buscarPorId(id);
    }

    @PostMapping
    public PedidoServico salvarPedido(@RequestBody PedidoServico pedidoServico) {
        // Buscar o cliente pelo ID enviado na requisição
        Cliente cliente = clienteService.buscarPorCodigo(pedidoServico.getCliente().getCodigo())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Associar o cliente ao pedido
        pedidoServico.setCliente(cliente);

        // Salvar o pedido
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

    // Método para buscar clientes pelo nome
    @GetMapping("/clientes/nome/{nome}")
    public List<Cliente> buscarClientesPorNome(@PathVariable String nome) {
        return clienteService.buscarPorNome(nome);
    }

    // Método para buscar produtos pelo nome
    @GetMapping("/produtos/nome/{nome}")
    public List<ProdutoServico> buscarProdutosPorNome(@PathVariable String nome) {
        return produtoServicoService.buscarPorNome(nome); // Chama o serviço para buscar produtos
    }
}
