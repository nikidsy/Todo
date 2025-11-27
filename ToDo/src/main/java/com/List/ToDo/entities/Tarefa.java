package com.List.ToDo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;

    public Tarefa() {
    	
    }

    public Tarefa(String nome, String descricao, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.dtInicio = LocalDate.now();
    }

    public Long getId() {
        return id;
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

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDtInicio() {
        return dtInicio;
    }
    public void setDtInicio(LocalDate dtInicio) {
        this.dtInicio = dtInicio;
    }

    public LocalDate getDtFim() {
        return dtFim;
    }
    public void setDtFim(LocalDate dtFim) {
        this.dtFim = dtFim;
    }
}
