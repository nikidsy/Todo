package com.List.ToDo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.entities.Tarefa;
import com.List.ToDo.entities.Status;
import com.List.ToDo.repository.TarefaRepository;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponseDTO criarTarefa(TarefaRequestDTO dto) {

        Tarefa tarefa = new Tarefa();
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(Status.PENDENTE);
        tarefa.setDtInicio(java.time.LocalDate.now());

        tarefaRepository.save(tarefa);

        return new TarefaResponseDTO(tarefa);
    }

    public TarefaResponseDTO buscarPorId(long id) {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada");
        }

        Tarefa tarefa = tarefaOptional.get();
        return new TarefaResponseDTO(tarefa);
    }

    public TarefaResponseDTO atualizar(long id, TarefaRequestDTO dto) {

        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);

        if (tarefaOptional.isEmpty()) {
            throw new RuntimeException("Tarefa não encontrada");
        }

        Tarefa tarefa = tarefaOptional.get();

        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setDtFim(java.time.LocalDate.now());

        tarefaRepository.save(tarefa);

        return new TarefaResponseDTO(tarefa);
    }

    public boolean deletar(long id) {

        if (!tarefaRepository.existsById(id)) {
            return false;
        }

        tarefaRepository.deleteById(id);
        return true;
    }
}
