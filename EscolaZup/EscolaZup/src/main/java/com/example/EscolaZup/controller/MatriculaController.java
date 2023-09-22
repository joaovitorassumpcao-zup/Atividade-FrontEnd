package com.example.EscolaZup.controller;

import com.example.EscolaZup.DTOS.MatriculaDTO;
import com.example.EscolaZup.model.Matricula;
import com.example.EscolaZup.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin("http://127.0.0.1:5500/")
public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula>fazerMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        Matricula novaMatricula = matriculaService.fazerMatricula(matriculaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMatricula);
    }
}
