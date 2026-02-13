package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Tarefa;

public class TarefaResponseDTO {

    private String nome;
    private String descricao;
    private Status status;

    private Long usuarioId;
    private String usuarioNome;
    private String usuarioEmail;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.nome = tarefa.getNome();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();

        this.usuarioId = tarefa.getUsuario().getId();
        this.usuarioNome = tarefa.getUsuario().getNome();
        this.usuarioEmail = tarefa.getUsuario().getEmail();
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }
}
