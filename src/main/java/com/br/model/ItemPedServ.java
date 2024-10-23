package com.br.model;

//ItemPedServ.java

import jakarta.persistence.*;

@Entity
@Table(name = "item_pedido_serv")
public class ItemPedServ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "pedido_servico_id")
	private PedidoServico pedidoServico;

	@ManyToOne
	@JoinColumn(name = "produto_servico_id")
	private ProdutoServico produtoServico;

	private double qtdeItem;

	public ItemPedServ(Long codigo, PedidoServico pedidoServico, ProdutoServico produtoServico, double qtdeItem) {
		super();
		this.codigo = codigo;
		this.pedidoServico = pedidoServico;
		this.produtoServico = produtoServico;
		this.qtdeItem = qtdeItem;
	}

	public ItemPedServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public PedidoServico getPedidoServico() {
		return pedidoServico;
	}

	public void setPedidoServico(PedidoServico pedidoServico) {
		this.pedidoServico = pedidoServico;
	}

	public ProdutoServico getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(ProdutoServico produtoServico) {
		this.produtoServico = produtoServico;
	}

	public double getQtdeItem() {
		return qtdeItem;
	}

	public void setQtdeItem(double qtdeItem) {
		this.qtdeItem = qtdeItem;
	}
	
	

}
