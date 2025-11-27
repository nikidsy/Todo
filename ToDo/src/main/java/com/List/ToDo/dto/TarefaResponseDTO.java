package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Tarefa;

public class TarefaResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Status status;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.nome = tarefa.getNome();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Status getStatus() {
        return status;
    }
}
