package com.universidade.appalunos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {

    // variáveis e suas respectivas declarações
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable=false)
    private String nome;
    @Column(name = "idade")
    private int idade;
    @Column(name = "curso")
    private String curso;

    //CONSTRUTORES
    public Aluno(){
    }

    public Aluno(String nome, int idade, String curso){
        super();
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    //GETTERS E SETTERS
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this. id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
}
