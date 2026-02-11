package com.List.ToDo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Usuario;
import com.List.ToDo.entities.Status;
import com.List.ToDo.repository.TarefaRepository;
import com.List.ToDo.repository.UsuarioRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    public TarefaService(TarefaRepository tarefaRepository,
                         UsuarioRepository usuarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public TarefaResponseDTO criarTarefaParaUsuario(Long usuarioId, TarefaRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(Status.PENDENTE);
        tarefa.setDtInicio(java.time.LocalDate.now());
        tarefa.setUsuario(usuario);

        tarefaRepository.save(tarefa);

        return new TarefaResponseDTO(tarefa);
    }

    public List<TarefaResponseDTO> listarTarefasPorUsuario(Long usuarioId) {

        if (!usuarioRepository.existsById(usuarioId)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return tarefaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(TarefaResponseDTO::new)
                .toList();
    }

    public TarefaResponseDTO atualizar(Long id, TarefaRequestDTO dto) {

        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDtFim(java.time.LocalDate.now());

        tarefaRepository.save(tarefa);

        return new TarefaResponseDTO(tarefa);
    }

    public void deletar(Long id) {

        if (!tarefaRepository.existsById(id)) {
            throw new RuntimeException("Tarefa não encontrada");
        }

        tarefaRepository.deleteById(id);
    }
}
