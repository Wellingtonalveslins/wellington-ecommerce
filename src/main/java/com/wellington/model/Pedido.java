package com.wellington.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double total;
    private String status;
    private LocalDateTime dataPedido;

    // relacionamento com usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // relacionamento com produtos
    @ManyToMany
    @JoinTable(
        name = "pedido_produtos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    // getters e setters
    public Long getId() { return id; }

    public Double getTotal() { return total; }

    public void setTotal(Double total) { this.total = total; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getDataPedido() { return dataPedido; }

    public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<Produto> getProdutos() { return produtos; }

    public void setProdutos(List<Produto> produtos) { this.produtos = produtos; }
}