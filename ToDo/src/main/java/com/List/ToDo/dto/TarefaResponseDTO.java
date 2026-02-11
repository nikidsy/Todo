package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repository.TarefaRepository;
import com.List.ToDo.repository.UsuarioRepository;

import java.time.LocalDate;

public class TarefaResponseDTO {

    private String nome;
    private String descricao;
    private Status status;
    private LocalDate dtInicio;
    private LocalDate dtFim;
    private Usuario usuario;

    public TarefaResponseDTO(Tarefa tarefa) {
        this.nome = tarefa.getNome();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dtInicio = tarefa.getDtInicio();
        this.dtFim = tarefa.getDtFim();
        this.usuario = tarefa.getUsuario();
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
