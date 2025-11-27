package com.List.ToDo.dto;

import com.List.ToDo.entities.Usuario;

public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;

    public UsuarioResponseDTO(Usuario entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
    }

    public long getId() { 
    	return id; 
    }
    
    public String getNome() { 
    	return nome; 
    }
    
    public String getEmail() {
    	return email; 
    }
}
