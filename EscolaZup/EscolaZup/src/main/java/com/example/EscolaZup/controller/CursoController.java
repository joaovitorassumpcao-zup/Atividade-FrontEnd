package com.example.EscolaZup.controller;

import com.example.EscolaZup.DTOS.CursoDTO;
import com.example.EscolaZup.model.Curso;
import com.example.EscolaZup.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin("http://127.0.0.1:5500/")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso>cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso novoCurso = cursoService.cadastrarCurso(cursoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    @GetMapping
    public ResponseEntity<List<Curso>>listarCurso() {
        List<Curso> cursos = cursoService.listarCurso();
        return ResponseEntity.ok(cursos);
    }

    @DeleteMapping("/{cursoId}")
    public ResponseEntity<String> deletarCurso(@PathVariable Long cursoId) {
        cursoService.deletarCurso(cursoId);
        return ResponseEntity.ok("Curso deletado com sucesso.");
    }
}
