package com.br.model;

//PedidoServico.java


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido_servico")
public class PedidoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    private double valorTotal;
    private LocalDate dataServico;

    @OneToMany(mappedBy = "pedidoServico", cascade = CascadeType.ALL)
    private List<ItemPedServ> lista;




public PedidoServico(Long codigo, Cliente cliente, double valorTotal, LocalDate dataServico,
			List<ItemPedServ> lista) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.dataServico = dataServico;
		this.lista = lista;
	}

public PedidoServico() {
	super();
	// TODO Auto-generated constructor stub
}

public Long getCodigo() {
	return codigo;
}

public void setCodigo(Long codigo) {
	this.codigo = codigo;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public double getValorTotal() {
	return valorTotal;
}

public void setValorTotal(double valorTotal) {
	this.valorTotal = valorTotal;
}

public LocalDate getDataServico() {
	return dataServico;
}

public void setDataServico(LocalDate dataServico) {
	this.dataServico = dataServico;
}

public List<ItemPedServ> getLista() {
	return lista;
}

public void setLista(List<ItemPedServ> lista) {
	this.lista = lista;
}


 
 

}
