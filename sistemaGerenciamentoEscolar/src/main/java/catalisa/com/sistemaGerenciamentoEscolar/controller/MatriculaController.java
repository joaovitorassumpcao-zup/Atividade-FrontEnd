package catalisa.com.sistemaGerenciamentoEscolar.controller;

import catalisa.com.sistemaGerenciamentoEscolar.DTO.MatriculaDTO;
import catalisa.com.sistemaGerenciamentoEscolar.model.Matricula;
import catalisa.com.sistemaGerenciamentoEscolar.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;




    public ResponseEntity<List<MatriculaDTO>> listarTodasMatriculas(){
        List<Matricula> matriculas = matriculaService.listarTodasMatriculas();
        List<MatriculaDTO> listaDTO = matriculas.stream().map(MatriculaDTO::new).collect(Collectors.toList());
        return  ResponseEntity.ok().body(listaDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> buscarMatriculaPorId(@PathVariable Long id){
        Matricula matricula = matriculaService.buscarMatriculaPorId(id);
        return  ResponseEntity.ok().body(new MatriculaDTO(matricula));
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<MatriculaDTO> cadastrarMatricula(@RequestBody Matricula matricula){
        matricula = matriculaService.cadastrarMatricula(matricula);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(matricula.getId()).toUri();
        return ResponseEntity.created(uri).body(new MatriculaDTO(matricula));
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarMatriculaPorId(@PathVariable Long id){
        matriculaService.deletarMatriculaPorId(id);
        return  ResponseEntity.noContent().build();
    }
    @PutMapping("@atualizar/{id}")
    public ResponseEntity<MatriculaDTO> atualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula){
        matricula = matriculaService.alterarCadastroMatricula(id, matricula);
        return  ResponseEntity.ok().body(new MatriculaDTO(matricula));
    }




}
