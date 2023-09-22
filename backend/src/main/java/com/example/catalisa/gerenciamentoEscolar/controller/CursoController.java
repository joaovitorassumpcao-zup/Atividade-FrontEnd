package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.CursoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cursos")
public class CursoController {
    @Autowired
    CursoService cursoService;

    //ENDPOINTS

    //REQUISIÇÃO GET
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<CursoDTOExibicao>> listarCursos(){
        return ResponseEntity.ok(cursoService.exibirCursos());
    }

    //REQUISIÇÃO POST
    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<CursoDTO> cadastrarNovoCurso(@RequestBody CursoDTO cursoDTO){
        cursoService.cadastrarCurso(cursoDTO);
        return ResponseEntity.ok().body(cursoDTO);
    }

    //REQUISIÇÃO DELETE
    @DeleteMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public void deletarCurso(@PathVariable Long id){
        cursoService.excluirCurso(id);
    }

}
