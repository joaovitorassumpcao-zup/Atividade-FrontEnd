package com.example.EscolaZup.controller;

import com.example.EscolaZup.DTOS.AlunoDTO;
import com.example.EscolaZup.model.Aluno;
import com.example.EscolaZup.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("http://127.0.0.1:5500/")
public class AlunoController {

    @Autowired
    AlunoService alunoService;


    @PostMapping
    public ResponseEntity<Aluno>cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno novoAluno = alunoService.cadastrarAluno(alunoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>>listarAluno() {
        List<Aluno> alunos = alunoService.listarAluno();
        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{alunoId}/curso")
    public ResponseEntity<String>atualizarCursoDoAluno(
            @PathVariable Long alunoId,
            @RequestParam Long novoCursoId) {
        alunoService.atualizarCursoDoAluno(alunoId, novoCursoId);
        return ResponseEntity.ok("Curso do aluno atualizado com sucesso");
    }

    @DeleteMapping("/{alunoId}")
    public ResponseEntity<String>deletarAluno(@PathVariable Long alunoId) {
        alunoService.deletarAluno(alunoId);
        return ResponseEntity.ok("Aluno deletado com sucesso");
    }
}
