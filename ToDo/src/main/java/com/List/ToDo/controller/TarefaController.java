package com.List.ToDo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.service.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criar(@RequestBody TarefaRequestDTO dto) {
        return ResponseEntity.ok(tarefaService.criarTarefa(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable long id) {
        try {
            TarefaResponseDTO tarefa = tarefaService.buscarPorId(id);
            return ResponseEntity.ok(tarefa);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable long id, @RequestBody TarefaRequestDTO dto) {
        try {
            TarefaResponseDTO tarefaAtualizada = tarefaService.atualizar(id, dto);
            return ResponseEntity.ok(tarefaAtualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable long id) {
        boolean deletado = tarefaService.deletar(id);

        if (deletado) {
            return ResponseEntity.ok("Tarefa deletada com sucesso!");
        }

        return ResponseEntity.notFound().build();
    }
}
