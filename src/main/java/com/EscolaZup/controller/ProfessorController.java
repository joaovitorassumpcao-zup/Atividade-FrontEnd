package com.EscolaZup.controller;

import com.EscolaZup.dto.ProfessorDTO;
import com.EscolaZup.mapper.ProfessorMapper;
import com.EscolaZup.model.Professor;
import com.EscolaZup.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zupescolafull/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @Autowired
    ProfessorMapper professorMapper;

    //Endpoint de cadastro do professor (post)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ResponseEntity<ProfessorDTO> cadastraProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorService.cadastrarProfessor(professor);
        return new ResponseEntity<>(professorMapper.toDto(professor), HttpStatus.CREATED);
    }

    //Endpoint apaga professor (delete)
    @DeleteMapping(path = "/{id}")
    public void detelaProfessor(@PathVariable Long id) {
        professorService.deletar(id);
    }

    //Endpoint para listar todos professoress (get)
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public List<Professor> buscaTodosProfessores() {
        return professorService.buscarTodos();
    }
}
