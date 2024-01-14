package com.example.correios.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_PEDIDO")
public class Pedido implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pedido_id")
    private int idPedido;

    @Column(nullable = false)
    private String dataPedido;

    @Column(nullable = false)
    private String dataEntrega;

    @Column
    private Boolean statusEntrega;

    // Associações

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "produto_id")
    private Produto produto;

    @Column(nullable = false)
    private int quantidade = produto.getQuantidade();

    @Column(nullable = false)
    private double valorTotal = produto.getPreco() * quantidade;

    @ManyToOne
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    // Construtores

    public Pedido() {
    }

    public Pedido(int idPedido, String dataPedido, String dataEntrega, Boolean statusEntrega, double valorTotal, int quantidade, Pessoa pessoa, Produto produto, Endereco endereco) {
        this.idPedido = idPedido;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.statusEntrega = statusEntrega;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
        this.pessoa = pessoa;
        this.produto = produto;
        this.endereco = endereco;
    }

    // Getters & Setters


    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Boolean getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(Boolean statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
