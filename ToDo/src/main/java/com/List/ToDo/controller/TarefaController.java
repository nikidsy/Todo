package com.List.ToDo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.service.TarefaService;

@RestController
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }
    @PostMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<TarefaResponseDTO> criar(
            @PathVariable Long id,
            @RequestBody TarefaRequestDTO dto) {

        return ResponseEntity.ok(
                tarefaService.criarTarefaParaUsuario(id, dto)
        );
    }

    @GetMapping("/usuarios/{id}/tarefas")
    public ResponseEntity<List<TarefaResponseDTO>> listar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                tarefaService.listarTarefasPorUsuario(id)
        );
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(
            @PathVariable Long id,
            @RequestBody TarefaRequestDTO dto) {

        return ResponseEntity.ok(
                tarefaService.atualizar(id, dto)
        );
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {

        tarefaService.deletar(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso!");
    }
}
