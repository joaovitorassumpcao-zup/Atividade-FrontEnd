package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.AlunoDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    //ENDPOINTS

    //REQUISIÇÃO GET
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<AlunoDTOExibicao>> listarAlunos(){
        return ResponseEntity.ok(alunoService.exibirAlunos());
    }

    //REQUISIÇÃO POST
    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<AlunoDTO> cadastrarNovoAluno(@RequestBody AlunoDTO alunoDTO){
        alunoService.cadastrarAluno(alunoDTO);
        return ResponseEntity.ok().body(alunoDTO);
    }

    //REQUISIÇÃO DELETE
    @DeleteMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public void deletarAluno(@PathVariable Long id){
        alunoService.excluirAluno(id);
    }

}
