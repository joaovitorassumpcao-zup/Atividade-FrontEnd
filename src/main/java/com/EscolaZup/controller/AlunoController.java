package com.EscolaZup.controller;

import com.EscolaZup.dto.AlunoDTO;
import com.EscolaZup.mapper.AlunoMapper;
import com.EscolaZup.model.Aluno;
import com.EscolaZup.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/zupescolafull/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @Autowired
    AlunoMapper alunoMapper;

    //Endpoint de cadastro de aluno (post)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ResponseEntity<AlunoDTO> cadastraAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.cadastraAluno(aluno);
        return new ResponseEntity<>(alunoMapper.toDto(aluno), HttpStatus.CREATED);
    }

    //Endpoint para apagar aluno (delete)
    @DeleteMapping(path = "/{id}")
    public void detelaAluno(@PathVariable Long id) {
        alunoService.deletar(id);
    }

    //Endpoint para listar todos alunos (get)
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public List<Aluno> buscaTodosAlunos() {
        return alunoService.buscarTodos();
    }
}
