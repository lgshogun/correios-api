package com.example.correios.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PESSOA")
public class Pessoa implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pessoa_id")
    private UUID idPessoa;

    @Column(length = 11, nullable = false)
    private int cpf;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    // Associações

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private Endereco endereco;

    @OneToOne(mappedBy = "pessoa")
    private Produto produto;

    @OneToOne(mappedBy = "pessoa")
    private Pedido pedido;

    // Construtores

    public Pessoa() {
    }

    public Pessoa(UUID idPessoa, int cpf, String nome, String email, Endereco endereco, Produto produto, Pedido pedido) {
        this.idPessoa = idPessoa;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.produto = produto;
        this.pedido = pedido;
    }

    // Getters & Setters


    public UUID getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(UUID idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
