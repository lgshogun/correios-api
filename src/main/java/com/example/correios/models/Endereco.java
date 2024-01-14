package com.example.correios.models;

import jakarta.persistence.*;
import org.aspectj.weaver.ast.Var;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "endereco_id")
    private UUID idEndereco;

    @Column(length = 8, nullable = false)
    private int cep;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private int numero;

    @Column
    private String complemento;

    // Associações

    @OneToOne(mappedBy = "endereco")
    private Pessoa pessoa;

    @OneToOne(mappedBy = "endereco")
    private Pedido pedido;

    // Construtores

    public Endereco() {
    }

    public Endereco(UUID idEndereco, int cep, String estado, String cidade, String bairro, String logradouro, int numero, String complemento, Pessoa pessoa, Pedido pedido) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.pessoa = pessoa;
        this.pedido = pedido;
    }

    // Getters & Setters


    public UUID getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(UUID idEndereco) {
        this.idEndereco = idEndereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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
