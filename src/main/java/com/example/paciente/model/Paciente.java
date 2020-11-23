package com.example.paciente.model;


import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Paciente implements Serializable {
    @Id
    private String id;
    private String nome;
    private String nomeResponsavel;
    private String altura;
    private String peso;
    private String dataDeNascimento;

    public Paciente(String nome, String nomeResponsavel, String altura, String peso, String dataDeNascimento) {
        this.nome = nome;
        this.nomeResponsavel = nomeResponsavel;
        this.altura = altura;
        this.peso = peso;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Paciente(){}

    public Paciente(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}