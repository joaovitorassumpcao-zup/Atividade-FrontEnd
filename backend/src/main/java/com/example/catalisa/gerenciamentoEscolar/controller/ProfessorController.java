package com.example.catalisa.gerenciamentoEscolar.controller;


import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.ProfessorDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    //ENDPOINTS

    //REQUISIÇÃO GET
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<ProfessorDTOExibicao>> listarProfessores(){
        return ResponseEntity.ok(professorService.exibirProfessores());
    }

    // REQUISIÇÃO POST
    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<ProfessorDTO> cadastrarProfessor(@RequestBody ProfessorDTO professorDTO){
        professorService.cadastrarProfessor(professorDTO);
        return ResponseEntity.ok().body(professorDTO);
    }

    //REQUISIÇÃO DELETE
    @DeleteMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public void deletarProfessor(@PathVariable Long id){
        professorService.excluirProfessor(id);
    }
}
