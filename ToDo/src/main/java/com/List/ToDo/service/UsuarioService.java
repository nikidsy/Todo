package com.List.ToDo.service;

import org.springframework.stereotype.Service;

import com.List.ToDo.dto.UsuarioRequestDTO;
import com.List.ToDo.dto.UsuarioResponseDTO;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO dto) {
        Usuario user = new Usuario(dto.getNome(), dto.getEmail(), dto.getSenha());
        usuarioRepository.save(user);
        return new UsuarioResponseDTO(user);
    }

    public UsuarioResponseDTO buscarPorId(Long id) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();
        return new UsuarioResponseDTO(usuario);
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO dto) {

        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Usuário não encontrado");
        }

        Usuario usuario = usuarioOptional.get();

        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(usuario);
    }

    public void deletarUsuario(Long id) {

        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        usuarioRepository.deleteById(id);
    }
}
