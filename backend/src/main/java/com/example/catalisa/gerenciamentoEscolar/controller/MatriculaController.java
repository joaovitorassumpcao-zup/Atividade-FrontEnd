package com.example.catalisa.gerenciamentoEscolar.controller;

import com.example.catalisa.gerenciamentoEscolar.model.MatriculaModel;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTO;
import com.example.catalisa.gerenciamentoEscolar.model.dtos.MatriculaDTOExibicao;
import com.example.catalisa.gerenciamentoEscolar.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/matriculas")

public class MatriculaController {

    @Autowired
    MatriculaService matriculaService;

    //ENDPOINTS

    //REQUISIÇÃO PUT
    @PutMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<MatriculaModel> modificarCurso(@PathVariable Long id, @RequestBody Long cursosId){

        MatriculaModel matriculaModel = matriculaService.editarMatricula(id,cursosId);

        if(matriculaModel != null){
            return ResponseEntity.ok().body(matriculaModel);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    //REQUISIÇÃO GET
    @GetMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<List<MatriculaDTOExibicao>> listarMatriculas(){
        return ResponseEntity.ok(matriculaService.exibirMatriculas());
    }

    //REQUISIÇÃO POST
    @PostMapping
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public ResponseEntity<MatriculaDTO> fazerNovaMatricula(@RequestBody MatriculaDTO matriculaDTO){
        matriculaService.fazerMatricula(matriculaDTO);
        return ResponseEntity.ok().body(matriculaDTO);
    }

    //REQUISIÇÃO DELETE
    @DeleteMapping(path = "/{id}")
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    public void deletarMatricula(@PathVariable Long id){
        matriculaService.excluirMatricula(id);
    }

}
