package com.List.ToDo.dto;

import com.List.ToDo.entities.Status;
import jakarta.validation.constraints.NotBlank;

public class TarefaRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    private Status status;

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
}
