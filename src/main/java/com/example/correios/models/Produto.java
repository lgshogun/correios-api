package com.example.correios.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produto_id")
    private int idProduto;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private double preco;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id")
    private Pessoa pessoa;

    @OneToOne(mappedBy = "produto")
    private Pedido pedido;

    // Construtores

    public Produto() {
    }

    public Produto(int idProduto, String nome, String descricao, double preco, int quantidade, Pessoa pessoa, Pedido pedido) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.pessoa = pessoa;
        this.pedido = pedido;
    }

    // Getters & Setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
