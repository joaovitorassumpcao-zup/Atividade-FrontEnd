package com.example.EscolaZup.controller;

import com.example.EscolaZup.DTOS.ProfessorDTO;
import com.example.EscolaZup.model.Professor;
import com.example.EscolaZup.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
@CrossOrigin("http://127.0.0.1:5500/")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor>cadastrarProfessor(@RequestBody ProfessorDTO professorDTO) {
        Professor novoProfessor = professorService.cadastrarProfessor(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>>listarProfessor() {
        List<Professor> professores = professorService.listarProfessor();
        return ResponseEntity.ok(professores);
    }

    @DeleteMapping("/{professorId}")
    public ResponseEntity<String> deletarProfessor(@PathVariable Long professorId) {
        professorService.deletarProfessor(professorId);
        return ResponseEntity.ok("Professor deletado com sucesso.");
    }
}
