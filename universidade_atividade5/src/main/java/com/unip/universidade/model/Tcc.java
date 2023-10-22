package com.unip.universidade.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tcc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String titulo;
    private int ano;
    private int semestre;

    @OneToMany(mappedBy = "tcc", cascade = CascadeType.ALL)
    private List<Aluno> alunosGrupo = new ArrayList<Aluno>();

    public Tcc(String titulo, int ano, int semestre, List<Aluno> alunosGrupo) {
        this.titulo = titulo;
        this.ano = ano;
        this.semestre = semestre;
        this.alunosGrupo = alunosGrupo;
    }
}
