package com.unip.pizzaPlanet.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String descricao;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private float valor;
    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "tcc_codigo")
    private Tcc tcc;

    public Produto(String nome, String descricao, float valor, String tamanho) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.tamanho = tamanho;
    }

    public boolean atualizarValor(float valorNovo){
        this.valor = valorNovo;
        return true;
        
    }
}

class Pizza extends Produto{
    public Pizza(String nome, String descricao, float valor, String tamanho) {
        super(nome, tamanho, valor, tamanho);
    }
}

class Bebida extends Produto{

    public Bebida(String nome, String descricao, float valor, String tamanho) {
        super(nome, tamanho, valor, tamanho);
    }
}
