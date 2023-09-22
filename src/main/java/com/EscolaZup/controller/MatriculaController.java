package com.EscolaZup.controller;

import com.EscolaZup.dto.MatriculaDTO;
import com.EscolaZup.mapper.MatriculaMapper;
import com.EscolaZup.model.Matricula;
import com.EscolaZup.model.Professor;
import com.EscolaZup.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/zupescolafull/matricula")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @Autowired
    MatriculaMapper matriculaMapper;

    //Endpoint de cadastro das matrículas (post)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public ResponseEntity<MatriculaDTO> cadastraMatricula(@RequestBody Matricula matricula) {
        Matricula novaMatricula = matriculaService.cadastraMatricula(matricula);
        return new ResponseEntity<>(matriculaMapper.toDto(matricula), HttpStatus.CREATED);
    }

    //Endpoint que atualiza curso do aluno (put)
    @PutMapping(path = "/{cursoid}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaDTO> atualizaCurso(@PathVariable Long alunoid, @PathVariable Long cursoid) {
        Matricula atualizaMatricula = new Matricula();
        atualizaMatricula.setAlunoid(alunoid);
        atualizaMatricula.setCursoid(cursoid);
        atualizaMatricula.setDatamatricula(LocalDate.now());
        matriculaService.atualizaCurso(atualizaMatricula);
        return new ResponseEntity<>(matriculaMapper.toDto(atualizaMatricula), HttpStatus.CREATED);

    }


    //Endpoint que consulta curso do aluno (get)
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    public List<Matricula> buscaTodasMatriculas() {
        return matriculaService.buscarTodos();
    }



}
